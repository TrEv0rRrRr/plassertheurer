package com.plassertheurer.platform.u20231b475.inspections.domain.model.valueobjects;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;

/**
 * This VO represents the vehicle code. It's the business unique identifier.
 */
public record VehicleCode(@NotBlank(message = "The vehicle code is required") String vehicleCode) {
  public VehicleCode {
    try {
      UUID.fromString(vehicleCode);
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException("Vehicle code must be a valid UUID", e);
    }
  }
}
