package com.plassertheurer.platform.u20231b475.inspections.application.internal.eventhandlers;

import java.time.LocalDate;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.plassertheurer.platform.u20231b475.inspections.application.internal.outboundservices.acl.ExternalMonitoringService;
import com.plassertheurer.platform.u20231b475.inspections.domain.model.events.MaintenanceTaskRequiredEvent;
// import com.plassertheurer.platform.u20231b475.inspections.infrastructure.persistence.jpa.repositories.InspectionRecordRepository;

@Service
public class MaintenanceTaskRequiredEventHandler {
  private final ExternalMonitoringService service;
  // private final InspectionRecordRepository repo;

  public MaintenanceTaskRequiredEventHandler(ExternalMonitoringService service) {
    this.service = service;
    // this.repo = repo;
  }

  @EventListener
  @Transactional
  public void on(MaintenanceTaskRequiredEvent event) {
    double range = event.getMaxAcceptableValue() - event.getMinAcceptableValue();
    double tolerance = range * 0.10;
    double upperLimit = event.getMaxAcceptableValue() + tolerance;
    boolean isOutOfRange = event.getMeasuredValue() > upperLimit;

    String priority = isOutOfRange ? "HIGH" : "MEDIUM";

    // TODO: Agregar condición para la fecha según el pdf
    LocalDate inspectedAt = LocalDate.now();
    LocalDate dueDate = inspectedAt.plusDays(3);

    // TODO: Crear descripción
    String description = "descripción";

    service.createMaintenanceTask(
        event.getVehicleCode(),
        event.getParameter(),
        description,
        priority,
        dueDate,
        "OPEN");
  }
}
