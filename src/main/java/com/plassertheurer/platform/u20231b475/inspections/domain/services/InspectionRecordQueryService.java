package com.plassertheurer.platform.u20231b475.inspections.domain.services;

import java.util.Optional;

import com.plassertheurer.platform.u20231b475.inspections.domain.model.aggregates.InspectionRecord;
import com.plassertheurer.platform.u20231b475.inspections.domain.model.queries.GetInspectionRecordByVehicleCodeAndCreatedAtQuery;

public interface InspectionRecordQueryService {
  Optional<InspectionRecord> handle(GetInspectionRecordByVehicleCodeAndCreatedAtQuery query);
}
