package com.plassertheurer.platform.u20231b475.regulations.application.internal.commandservices;

import java.util.List;

import org.springframework.stereotype.Service;

import com.plassertheurer.platform.u20231b475.regulations.domain.model.aggregates.SafetyStandard;
import com.plassertheurer.platform.u20231b475.regulations.domain.model.commands.SeedSafetyStandardsCommand;
import com.plassertheurer.platform.u20231b475.regulations.domain.services.SafetyStandardCommandService;
import com.plassertheurer.platform.u20231b475.regulations.infrastructure.persistence.jpa.repositories.SafetyStandardRepository;

@Service
public class SafetyStandardCommandServiceImpl implements SafetyStandardCommandService {
  private final SafetyStandardRepository repo;

  public SafetyStandardCommandServiceImpl(SafetyStandardRepository repo) {
    this.repo = repo;
  }

  @Override
  public void handle(SeedSafetyStandardsCommand command) {
    if (repo.count() > 0)
      return;

    repo.saveAll(List.of(
        new SafetyStandard("TRACK", "rail_alignment", -2.0, 2.0),
        new SafetyStandard("TRACK", "gauge_width", 1433.0, 1437.0),
        new SafetyStandard("SWITCH", "point_position", 0.0, 5.0),
        new SafetyStandard("BRIDGE", "vibration_level", 0.0, 1.5)));
  }
}
