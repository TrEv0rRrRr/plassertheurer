package com.plassertheurer.platform.u20231b475.regulations.domain.services;

import com.plassertheurer.platform.u20231b475.regulations.domain.model.commands.SeedSafetyStandardsCommand;

public interface SafetyStandardCommandService {
  void handle(SeedSafetyStandardsCommand command);
}
