package com.plassertheurer.platform.u20231b475.inspections.domain.model.queries;

import java.time.LocalDateTime;

import com.plassertheurer.platform.u20231b475.inspections.domain.model.valueobjects.VehicleCode;

/**
 * Query to get an inspection record by vehicle code and creation date
 */
public record GetInspectionRecordByVehicleCodeAndCreatedAtQuery(VehicleCode vehicleCode, LocalDateTime inspectedAt) {
}
