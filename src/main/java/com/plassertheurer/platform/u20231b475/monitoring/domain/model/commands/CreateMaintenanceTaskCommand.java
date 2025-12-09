package com.plassertheurer.platform.u20231b475.monitoring.domain.model.commands;

import java.time.LocalDate;

import com.plassertheurer.platform.u20231b475.monitoring.domain.model.valueobjects.TaskPriority;
import com.plassertheurer.platform.u20231b475.monitoring.domain.model.valueobjects.TaskState;

public record CreateMaintenanceTaskCommand(String vehicleCode, String parameter, String description,
    TaskPriority priority, LocalDate dueDate, TaskState state) {
}
