package com.plassertheurer.platform.u20231b475.regulations.application.internal.eventhandlers;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.plassertheurer.platform.u20231b475.regulations.domain.model.commands.SeedSafetyStandardsCommand;
import com.plassertheurer.platform.u20231b475.regulations.domain.services.SafetyStandardCommandService;

@Service
public class ApplicationReadyEventHandler {
  private final SafetyStandardCommandService service;

  public ApplicationReadyEventHandler(SafetyStandardCommandService service) {
    this.service = service;
  }

  @EventListener
  public void on(ApplicationReadyEvent event) {
    var seedSafetyStandardsCommand = new SeedSafetyStandardsCommand();

    service.handle(seedSafetyStandardsCommand);
  }
}
