package com.plassertheurer.platform.u20231b475.inspections.application.internal.eventhandlers;

import java.time.LocalDate;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.plassertheurer.platform.u20231b475.inspections.application.internal.outboundservices.acl.ExternalMonitoringService;
import com.plassertheurer.platform.u20231b475.inspections.domain.model.events.MaintenanceTaskRequiredEvent;

@Service
public class MaintenanceTaskRequiredEventHandler {
  private final ExternalMonitoringService service;

  public MaintenanceTaskRequiredEventHandler(ExternalMonitoringService service) {
    this.service = service;
  }

  @EventListener
  @Transactional
  public void on(MaintenanceTaskRequiredEvent event) {
    double range = event.getMaxAcceptableValue() - event.getMinAcceptableValue();
    double tolerance = range * 0.10;
    double upperLimit = event.getMaxAcceptableValue() + tolerance;
    boolean isOutOfRange = event.getMeasuredValue() > upperLimit;
    LocalDate inspectedAt = event.getInspectedAt().toLocalDate();

    String priority = isOutOfRange ? "HIGH" : "MEDIUM";
    String state = isOutOfRange ? "IN_PROGRESS" : "OPEN";
    LocalDate dueDate = isOutOfRange ? inspectedAt.plusDays(1) : inspectedAt.plusDays(3);

    String description = String.format(
        "Maintenance required for %s: %s measured %.2f (acceptable range: %.2f - %.2f)",
        event.getInfrastructureType(),
        event.getParameter(),
        event.getMeasuredValue(),
        event.getMinAcceptableValue(),
        event.getMaxAcceptableValue());

    service.createMaintenanceTask(
        event.getVehicleCode(),
        event.getParameter(),
        description,
        priority,
        dueDate,
        state);
  }
}
