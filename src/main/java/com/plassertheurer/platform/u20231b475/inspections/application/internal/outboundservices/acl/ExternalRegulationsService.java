package com.plassertheurer.platform.u20231b475.inspections.application.internal.outboundservices.acl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.plassertheurer.platform.u20231b475.regulations.interfaces.acl.RegulationsContextFacade;
import com.plassertheurer.platform.u20231b475.regulations.interfaces.rest.resources.SafetyStandardResource;

@Service
public class ExternalRegulationsService {
  private final RegulationsContextFacade facade;

  public ExternalRegulationsService(RegulationsContextFacade facade) {
    this.facade = facade;
  }

  public Optional<SafetyStandardResource> fetchByParameter(String parameter) {
    return facade.fetchByParameter(parameter);
  }
}
