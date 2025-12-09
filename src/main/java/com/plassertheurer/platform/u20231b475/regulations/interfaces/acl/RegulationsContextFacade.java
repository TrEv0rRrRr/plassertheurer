package com.plassertheurer.platform.u20231b475.regulations.interfaces.acl;

import java.util.Optional;

import com.plassertheurer.platform.u20231b475.regulations.interfaces.rest.resources.SafetyStandardResource;

/**
 * RegulationsContextFacade
 */
public interface RegulationsContextFacade {
  /**
   * Fetches a safety standard by parameter
   * 
   * @param parameter
   * @return
   */
  Optional<SafetyStandardResource> fetchByParameter(String parameter);
}
