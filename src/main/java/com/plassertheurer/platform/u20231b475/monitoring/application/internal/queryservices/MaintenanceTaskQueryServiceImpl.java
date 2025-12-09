package com.plassertheurer.platform.u20231b475.monitoring.application.internal.queryservices;

import java.util.List;

import org.springframework.stereotype.Service;

import com.plassertheurer.platform.u20231b475.monitoring.domain.model.aggregates.MaintenanceTask;
import com.plassertheurer.platform.u20231b475.monitoring.domain.model.queries.GetAllMaintenanceTasksQuery;
import com.plassertheurer.platform.u20231b475.monitoring.domain.services.MaintenanceTaskQueryService;
import com.plassertheurer.platform.u20231b475.monitoring.infrastructure.persistence.jpa.repositories.MaintenanceTaskRepository;

@Service
public class MaintenanceTaskQueryServiceImpl implements MaintenanceTaskQueryService {
  private final MaintenanceTaskRepository repo;

  public MaintenanceTaskQueryServiceImpl(MaintenanceTaskRepository repo) {
    this.repo = repo;
  }

  @Override
  public List<MaintenanceTask> handle(GetAllMaintenanceTasksQuery query) {
    return repo.findAll();
  }
}
