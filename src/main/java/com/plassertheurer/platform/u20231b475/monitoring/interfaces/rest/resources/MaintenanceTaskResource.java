package com.plassertheurer.platform.u20231b475.monitoring.interfaces.rest.resources;

import java.time.LocalDate;

import com.plassertheurer.platform.u20231b475.monitoring.domain.model.valueobjects.TaskPriority;
import com.plassertheurer.platform.u20231b475.monitoring.domain.model.valueobjects.TaskState;
import com.plassertheurer.platform.u20231b475.monitoring.domain.model.valueobjects.VehicleCode;

public record MaintenanceTaskResource(Long id, VehicleCode vehicleCode, String parameter, String description,
    TaskPriority priority, LocalDate dueDate, TaskState state) {
}
