package com.plassertheurer.platform.u20231b475.regulations.domain.model.aggregates;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

/**
 * The safety standard aggregate root
 * 
 * @author Valentino Solis
 */
public class SafetyStandard {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Getter
  @NotBlank(message = "The infrastructure type is required")
  private String infrastructureType;

  @Getter
  @NotBlank(message = "The parameter is required")
  private String parameter;

  @Getter
  @Min(0)
  @NotNull(message = "The min acceptable value is required")
  private Double minAcceptableValue;

  @Getter
  @Min(0)
  @NotNull(message = "The max acceptable value is required")
  private Double maxAcceptableValue;

  public SafetyStandard() {
    // Empty for JPA purposes
  }

  public SafetyStandard(String infrastructureType,
      String parameter,
      Double minAcceptableValue,
      Double maxAcceptableValue) {
    this.infrastructureType = infrastructureType;
    this.parameter = parameter;
    this.minAcceptableValue = minAcceptableValue;
    this.maxAcceptableValue = maxAcceptableValue;
  }
}
