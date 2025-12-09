package com.plassertheurer.platform.u20231b475.monitoring.application.acl;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.plassertheurer.platform.u20231b475.monitoring.domain.model.commands.CreateMaintenanceTaskCommand;
import com.plassertheurer.platform.u20231b475.monitoring.domain.model.valueobjects.TaskPriority;
import com.plassertheurer.platform.u20231b475.monitoring.domain.model.valueobjects.TaskState;
import com.plassertheurer.platform.u20231b475.monitoring.domain.services.MaintenanceTaskCommandService;
import com.plassertheurer.platform.u20231b475.monitoring.interfaces.acl.MonitoringContextFacade;

@Service
public class MonitoringContextFacadeImpl implements MonitoringContextFacade {
  private final MaintenanceTaskCommandService service;

  public MonitoringContextFacadeImpl(MaintenanceTaskCommandService service) {
    this.service = service;
  }

  @Override
  public Long createMaintenanceTask(String vehicleCode, String parameter, String description,
      String priority, LocalDate dueDate, String state) {
    var command = new CreateMaintenanceTaskCommand(vehicleCode, parameter, description, TaskPriority.valueOf(priority),
        dueDate, TaskState.valueOf(state));

    return service.handle(command).orElseThrow(() -> new RuntimeException("Failed to create maintenance task")).getId();
  }
}
