package com.plassertheurer.platform.u20231b475.monitoring.domain.model.aggregates;

import java.time.LocalDate;

import com.plassertheurer.platform.u20231b475.monitoring.domain.model.commands.CreateMaintenanceTaskCommand;
import com.plassertheurer.platform.u20231b475.monitoring.domain.model.valueobjects.TaskPriority;
import com.plassertheurer.platform.u20231b475.monitoring.domain.model.valueobjects.TaskState;
import com.plassertheurer.platform.u20231b475.monitoring.domain.model.valueobjects.VehicleCode;
import com.plassertheurer.platform.u20231b475.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Entity
@Getter
public class MaintenanceTask extends AuditableAbstractAggregateRoot<MaintenanceTask> {
  @Embedded
  private VehicleCode vehicleCode;

  @NotBlank(message = "The parameter is required")
  private String parameter;

  @NotBlank(message = "The description is required")
  private String description;

  @Enumerated(EnumType.STRING)
  private TaskPriority priority;

  @NotNull(message = "The due date is required")
  private LocalDate dueDate;

  @Enumerated(EnumType.STRING)
  private TaskState state;

  public MaintenanceTask() {
    // Empty for JPA purposes
  }

  public MaintenanceTask(CreateMaintenanceTaskCommand command) {
    this.vehicleCode = new VehicleCode(command.vehicleCode());
    this.parameter = command.parameter();
    this.description = command.description();
    this.priority = command.priority();
    this.dueDate = command.dueDate();
    this.state = command.state();
  }
}
