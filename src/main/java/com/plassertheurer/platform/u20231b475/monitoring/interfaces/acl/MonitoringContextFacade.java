package com.plassertheurer.platform.u20231b475.monitoring.interfaces.acl;

import java.time.LocalDate;

public interface MonitoringContextFacade {
  Long createMaintenanceTask(String vehicleCode, String parameter, String description,
      String priority, LocalDate dueDate, String state);
}
