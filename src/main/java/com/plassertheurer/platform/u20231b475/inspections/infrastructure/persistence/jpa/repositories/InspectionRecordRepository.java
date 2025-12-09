package com.plassertheurer.platform.u20231b475.inspections.infrastructure.persistence.jpa.repositories;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plassertheurer.platform.u20231b475.inspections.domain.model.aggregates.InspectionRecord;
import com.plassertheurer.platform.u20231b475.inspections.domain.model.valueobjects.VehicleCode;

@Repository
public interface InspectionRecordRepository extends JpaRepository<InspectionRecord, Long> {
  Optional<InspectionRecord> findInspectionRecordByVehicleCodeAndInspectedAt(VehicleCode vehicleCode,
      LocalDateTime inspectedAt);

  boolean existsByVehicleCodeAndInspectedAt(VehicleCode vehicleCode, LocalDateTime inspectedAt);
}
