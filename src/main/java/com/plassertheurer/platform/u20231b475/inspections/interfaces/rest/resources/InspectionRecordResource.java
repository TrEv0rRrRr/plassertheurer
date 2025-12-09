package com.plassertheurer.platform.u20231b475.inspections.interfaces.rest.resources;

import java.time.LocalDateTime;

import com.plassertheurer.platform.u20231b475.inspections.domain.model.valueobjects.InspectionState;
import com.plassertheurer.platform.u20231b475.inspections.domain.model.valueobjects.VehicleCode;

public record InspectionRecordResource(Long id, VehicleCode vehicleCode, String infrastructureType, String parameter,
    Double measuredValue, InspectionState state, LocalDateTime inspectedAt) {

}
