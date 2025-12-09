package com.plassertheurer.platform.u20231b475.monitoring.application.internal.commandservices;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.plassertheurer.platform.u20231b475.monitoring.domain.model.aggregates.MaintenanceTask;
import com.plassertheurer.platform.u20231b475.monitoring.domain.model.commands.CreateMaintenanceTaskCommand;
import com.plassertheurer.platform.u20231b475.monitoring.domain.services.MaintenanceTaskCommandService;
import com.plassertheurer.platform.u20231b475.monitoring.infrastructure.persistence.jpa.repositories.MaintenanceTaskRepository;

@Service
public class MaintenanceTaskCommandServiceImpl implements MaintenanceTaskCommandService {
  private final MaintenanceTaskRepository repo;

  public MaintenanceTaskCommandServiceImpl(MaintenanceTaskRepository repo) {
    this.repo = repo;
  }

  @Override
  public Optional<MaintenanceTask> handle(CreateMaintenanceTaskCommand command) {
    var maintenanceTask = new MaintenanceTask(command);

    repo.save(maintenanceTask);

    return Optional.of(maintenanceTask);
  }
}
