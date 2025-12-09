package com.plassertheurer.platform.u20231b475.regulations.application.acl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.plassertheurer.platform.u20231b475.regulations.domain.model.queries.GetSafetyStandardByParameterQuery;
import com.plassertheurer.platform.u20231b475.regulations.domain.services.SafetyStandardQueryService;
import com.plassertheurer.platform.u20231b475.regulations.interfaces.acl.RegulationsContextFacade;
import com.plassertheurer.platform.u20231b475.regulations.interfaces.rest.resources.SafetyStandardResource;
import com.plassertheurer.platform.u20231b475.regulations.interfaces.rest.transform.SafetyStandardResourceFromEntityAssembler;

@Service
public class RegulationsContextFacadeImpl implements RegulationsContextFacade {
  private final SafetyStandardQueryService service;

  public RegulationsContextFacadeImpl(SafetyStandardQueryService service) {
    this.service = service;
  }

  @Override
  public Optional<SafetyStandardResource> fetchByParameter(String parameter) {
    var query = new GetSafetyStandardByParameterQuery(parameter);

    return service.handle(query).map(SafetyStandardResourceFromEntityAssembler::toResourceFromEntity);
  }
}
