package com.plassertheurer.platform.u20231b475.inspections.application.internal.commandservices;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.plassertheurer.platform.u20231b475.inspections.domain.model.aggregates.InspectionRecord;
import com.plassertheurer.platform.u20231b475.inspections.domain.model.commands.CreateInspectionRecordCommand;
import com.plassertheurer.platform.u20231b475.inspections.domain.model.valueobjects.VehicleCode;
import com.plassertheurer.platform.u20231b475.inspections.domain.services.InspectionRecordCommandService;
import com.plassertheurer.platform.u20231b475.inspections.infrastructure.persistence.jpa.repositories.InspectionRecordRepository;

@Service
public class InspectionRecordCommandServiceImpl implements InspectionRecordCommandService {
  private final InspectionRecordRepository repo;

  public InspectionRecordCommandServiceImpl(InspectionRecordRepository repo) {
    this.repo = repo;
  }

  @Override
  public Optional<InspectionRecord> handle(CreateInspectionRecordCommand command) {
    var vehicleCode = new VehicleCode(command.vehicleCode());

    if (repo.existsByVehicleCodeAndInspectedAt(vehicleCode, command.inspectedAt())) {
      throw new IllegalArgumentException("An inspection record for the given properties already exists.");
    }
  }
}
