package com.plassertheurer.platform.u20231b475.inspections.interfaces.rest.resources;

import java.time.LocalDateTime;

import com.plassertheurer.platform.u20231b475.inspections.domain.model.valueobjects.InspectionState;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public record CreateInspectionRecordResource(
    @NotBlank(message = "The vehicle code is required") String vehicleCode,
    @NotBlank(message = "The infrastructure type is required") String infrastructureType,
    @NotBlank(message = "The parameter is required") String parameter,
    @NotNull(message = "The measured value is required") Double measuredValue, InspectionState state,
    @NotNull(message = "The inspection date is required") @PastOrPresent LocalDateTime inspectedAt) {

}
