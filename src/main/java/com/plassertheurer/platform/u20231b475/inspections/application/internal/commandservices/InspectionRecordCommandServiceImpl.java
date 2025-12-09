package com.plassertheurer.platform.u20231b475.inspections.application.internal.commandservices;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.plassertheurer.platform.u20231b475.inspections.application.internal.outboundservices.acl.ExternalRegulationsService;
import com.plassertheurer.platform.u20231b475.inspections.domain.model.aggregates.InspectionRecord;
import com.plassertheurer.platform.u20231b475.inspections.domain.model.commands.CreateInspectionRecordCommand;
import com.plassertheurer.platform.u20231b475.inspections.domain.model.valueobjects.VehicleCode;
import com.plassertheurer.platform.u20231b475.inspections.domain.services.InspectionRecordCommandService;
import com.plassertheurer.platform.u20231b475.inspections.infrastructure.persistence.jpa.repositories.InspectionRecordRepository;

@Service
public class InspectionRecordCommandServiceImpl implements InspectionRecordCommandService {
  private final InspectionRecordRepository repo;
  private final ExternalRegulationsService regulationsService;

  public InspectionRecordCommandServiceImpl(InspectionRecordRepository repo,
      ExternalRegulationsService regulationsService) {
    this.repo = repo;
    this.regulationsService = regulationsService;
  }

  @Override
  public Optional<InspectionRecord> handle(CreateInspectionRecordCommand command) {
    var vehicleCode = new VehicleCode(command.vehicleCode());

    if (repo.existsByVehicleCodeAndInspectedAt(vehicleCode, command.inspectedAt())) {
      throw new IllegalArgumentException("An inspection record for the given properties already exists.");
    }

    var safetyStandard = regulationsService.fetchByParameter(command.parameter())
        .orElseThrow(() -> new IllegalArgumentException("Safety standard not found"));

    boolean isOutOfRange = command.measuredValue() > safetyStandard.maxAcceptableValue()
        || command.measuredValue() < safetyStandard.minAcceptableValue();

    var inspectionRecord = new InspectionRecord(command);

    repo.save(inspectionRecord);

    if (isOutOfRange) {
      inspectionRecord.maintenanceTaskRequired(safetyStandard.minAcceptableValue(),
          safetyStandard.maxAcceptableValue());
      repo.save(inspectionRecord);
    }

    return Optional.of(inspectionRecord);
  }
}
