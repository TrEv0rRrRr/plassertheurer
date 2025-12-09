package com.plassertheurer.platform.u20231b475.regulations.infrastructure.persistence.jpa.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plassertheurer.platform.u20231b475.regulations.domain.model.aggregates.SafetyStandard;

/**
 * SafetyStandardRepository
 */
@Repository
public interface SafetyStandardRepository extends JpaRepository<SafetyStandard, Long> {
  /**
   * Find a safety standard by parameter
   * 
   * @param parameter
   * @return A {@link SafetyStandard} instance if the provided property is valid,
   *         otherwise empty
   */
  Optional<SafetyStandard> findByParameter(String parameter);
}
