package com.plassertheurer.platform.u20231b475.inspections.interfaces.rest.transform;

import com.plassertheurer.platform.u20231b475.inspections.domain.model.aggregates.InspectionRecord;
import com.plassertheurer.platform.u20231b475.inspections.interfaces.rest.resources.InspectionRecordResource;

public class InspectionRecordResourceFromEntityAssembler {
  public static InspectionRecordResource toResourceFromEntity(InspectionRecord entity) {
    return new InspectionRecordResource(
        entity.getId(),
        entity.getVehicleCode(),
        entity.getInfrastructureType(),
        entity.getParameter(),
        entity.getMeasuredValue(),
        entity.getState(),
        entity.getInspectedAt());
  }
}
