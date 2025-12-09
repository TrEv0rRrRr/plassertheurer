package com.plassertheurer.platform.u20231b475.inspections.domain.model.aggregates;

import java.time.LocalDateTime;

import com.plassertheurer.platform.u20231b475.inspections.domain.model.commands.CreateInspectionRecordCommand;
import com.plassertheurer.platform.u20231b475.inspections.domain.model.valueobjects.InspectionState;
import com.plassertheurer.platform.u20231b475.inspections.domain.model.valueobjects.VehicleCode;
import com.plassertheurer.platform.u20231b475.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Getter;

@Entity
@Getter
public class InspectionRecord extends AuditableAbstractAggregateRoot<InspectionRecord> {
  @Embedded
  private VehicleCode vehicleCode;

  @NotBlank(message = "The infrastructure type is required")
  private String infrastructureType;

  @NotBlank(message = "The parameter is required")
  private String parameter;

  @NotNull(message = "The measured value is required")
  private Double measuredValue;

  @Enumerated(EnumType.STRING)
  private InspectionState state;

  @NotNull(message = "The inspection date is required")
  @Past
  private LocalDateTime inspectedAt;

  public InspectionRecord() {
    // Empty for JPA
  }

  public InspectionRecord(CreateInspectionRecordCommand command) {
    this.vehicleCode = new VehicleCode(command.vehicleCode());
    this.infrastructureType = command.infrastructureType();
    this.parameter = command.parameter();
    this.measuredValue = command.measuredValue();
    this.state = command.state();
    this.inspectedAt = command.inspectedAt();
  }
}
