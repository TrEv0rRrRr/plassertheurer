package com.plassertheurer.platform.u20231b475.regulations.application.internal.queryservices;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.plassertheurer.platform.u20231b475.regulations.domain.model.aggregates.SafetyStandard;
import com.plassertheurer.platform.u20231b475.regulations.domain.model.queries.GetSafetyStandardByParameterQuery;
import com.plassertheurer.platform.u20231b475.regulations.domain.services.SafetyStandardQueryService;
import com.plassertheurer.platform.u20231b475.regulations.infrastructure.persistence.jpa.repositories.SafetyStandardRepository;

@Service
public class SafetyStandardQueryServiceImpl implements SafetyStandardQueryService {
  private final SafetyStandardRepository repo;

  public SafetyStandardQueryServiceImpl(SafetyStandardRepository repo) {
    this.repo = repo;
  }

  @Override
  public Optional<SafetyStandard> handle(GetSafetyStandardByParameterQuery query) {
    return repo.findByParameter(query.parameter());
  }
}
