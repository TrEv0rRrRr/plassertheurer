package com.plassertheurer.platform.u20231b475.monitoring.domain.services;

import java.util.List;

import com.plassertheurer.platform.u20231b475.monitoring.domain.model.aggregates.MaintenanceTask;
import com.plassertheurer.platform.u20231b475.monitoring.domain.model.queries.GetAllMaintenanceTasksQuery;

public interface MaintenanceTaskQueryService {
  List<MaintenanceTask> handle(GetAllMaintenanceTasksQuery query);
}
