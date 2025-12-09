package com.plassertheurer.platform.u20231b475.monitoring.interfaces.rest.transform;

import com.plassertheurer.platform.u20231b475.monitoring.domain.model.aggregates.MaintenanceTask;
import com.plassertheurer.platform.u20231b475.monitoring.interfaces.rest.resources.MaintenanceTaskResource;

public class MaintenanceTaskResourceFromEntityAssembler {
  public static MaintenanceTaskResource toResourceFromEntity(MaintenanceTask entity) {
    return new MaintenanceTaskResource(
        entity.getId(),
        entity.getVehicleCode(),
        entity.getParameter(),
        entity.getDescription(),
        entity.getPriority(),
        entity.getDueDate(),
        entity.getState());
  }
}
