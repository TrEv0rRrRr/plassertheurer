package com.plassertheurer.platform.u20231b475.inspections.application.internal.queryservices;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.plassertheurer.platform.u20231b475.inspections.domain.model.aggregates.InspectionRecord;
import com.plassertheurer.platform.u20231b475.inspections.domain.model.queries.GetInspectionRecordByVehicleCodeAndCreatedAtQuery;
import com.plassertheurer.platform.u20231b475.inspections.domain.services.InspectionRecordQueryService;
import com.plassertheurer.platform.u20231b475.inspections.infrastructure.persistence.jpa.repositories.InspectionRecordRepository;

@Service
public class InspectionRecordQueryServiceImpl implements InspectionRecordQueryService {
  private final InspectionRecordRepository repo;

  public InspectionRecordQueryServiceImpl(InspectionRecordRepository repo) {
    this.repo = repo;
  }

  @Override
  public Optional<InspectionRecord> handle(GetInspectionRecordByVehicleCodeAndCreatedAtQuery query) {
    return repo.findInspectionRecordByVehicleCodeAndInspectedAt(query.vehicleCode(), query.inspectedAt());
  }
}
