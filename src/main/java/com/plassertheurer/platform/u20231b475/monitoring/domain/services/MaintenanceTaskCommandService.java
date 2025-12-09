package com.plassertheurer.platform.u20231b475.monitoring.domain.services;

import java.util.Optional;

import com.plassertheurer.platform.u20231b475.monitoring.domain.model.aggregates.MaintenanceTask;
import com.plassertheurer.platform.u20231b475.monitoring.domain.model.commands.CreateMaintenanceTaskCommand;

public interface MaintenanceTaskCommandService {
  Optional<MaintenanceTask> handle(CreateMaintenanceTaskCommand command);
}
