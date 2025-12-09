package com.plassertheurer.platform.u20231b475.regulations.domain.services;

import java.util.Optional;

import com.plassertheurer.platform.u20231b475.regulations.domain.model.aggregates.SafetyStandard;
import com.plassertheurer.platform.u20231b475.regulations.domain.model.queries.GetSafetyStandardByParameterQuery;

/**
 * Service for query handling
 */
public interface SafetyStandardQueryService {
  Optional<SafetyStandard> handle(GetSafetyStandardByParameterQuery query);
}
