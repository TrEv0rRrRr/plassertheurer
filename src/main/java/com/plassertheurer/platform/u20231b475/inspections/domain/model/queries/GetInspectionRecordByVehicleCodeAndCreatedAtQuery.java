package com.plassertheurer.platform.u20231b475.inspections.domain.model.queries;

import java.util.Date;

/**
 * Query to get an inspection record by vehicle code and creation date
 */
public record GetInspectionRecordByVehicleCodeAndCreatedAtQuery(String vehicleCode, Date createdAt) {
}
