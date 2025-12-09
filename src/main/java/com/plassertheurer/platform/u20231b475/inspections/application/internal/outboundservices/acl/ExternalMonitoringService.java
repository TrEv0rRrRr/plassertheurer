package com.plassertheurer.platform.u20231b475.inspections.application.internal.outboundservices.acl;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.plassertheurer.platform.u20231b475.monitoring.interfaces.acl.MonitoringContextFacade;

@Service
public class ExternalMonitoringService {
  private final MonitoringContextFacade facade;

  public ExternalMonitoringService(MonitoringContextFacade facade) {
    this.facade = facade;
  }

  public Long createMaintenanceTask(String vehicleCode, String parameter, String description,
      String priority, LocalDate dueDate, String state) {
    return facade.createMaintenanceTask(vehicleCode, parameter, description, priority, dueDate, state);
  }
}
