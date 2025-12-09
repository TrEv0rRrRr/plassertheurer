package com.plassertheurer.platform.u20231b475.inspections.interfaces.rest.transform;

import com.plassertheurer.platform.u20231b475.inspections.domain.model.commands.CreateInspectionRecordCommand;
import com.plassertheurer.platform.u20231b475.inspections.interfaces.rest.resources.CreateInspectionRecordResource;

public class CreateInspectionRecordCommandFromResourceAssembler {
  public static CreateInspectionRecordCommand toCommandFromResource(CreateInspectionRecordResource resource) {
    return new CreateInspectionRecordCommand(resource.vehicleCode(), resource.infrastructureType(),
        resource.parameter(), resource.measuredValue(), resource.state(), resource.inspectedAt());
  }
}
