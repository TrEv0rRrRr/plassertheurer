package com.plassertheurer.platform.u20231b475.regulations.interfaces.rest.transform;

import com.plassertheurer.platform.u20231b475.regulations.domain.model.aggregates.SafetyStandard;
import com.plassertheurer.platform.u20231b475.regulations.interfaces.rest.resources.SafetyStandardResource;

public class SafetyStandardResourceFromEntityAssembler {
  public static SafetyStandardResource toResourceFromEntity(SafetyStandard entity) {
    return new SafetyStandardResource(
        entity.getParameter(),
        entity.getMinAcceptableValue(),
        entity.getMaxAcceptableValue());
  }
}
