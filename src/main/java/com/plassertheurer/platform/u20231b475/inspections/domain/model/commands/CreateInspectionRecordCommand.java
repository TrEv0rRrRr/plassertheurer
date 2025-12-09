package com.plassertheurer.platform.u20231b475.inspections.domain.model.commands;

import java.time.LocalDateTime;

import com.plassertheurer.platform.u20231b475.inspections.domain.model.valueobjects.InspectionState;

/**
 * Command for inspection records creation
 */
public record CreateInspectionRecordCommand(String vehicleCode, String infrastructureType, String parameter,
        Double measuredValue, InspectionState state, LocalDateTime inspectedAt) {
}
