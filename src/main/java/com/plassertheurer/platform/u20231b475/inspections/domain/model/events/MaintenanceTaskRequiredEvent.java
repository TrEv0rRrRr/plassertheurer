package com.plassertheurer.platform.u20231b475.inspections.domain.model.events;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;

@Getter
public class MaintenanceTaskRequiredEvent extends ApplicationEvent {
  private Long inspectionRecordId;
  private Double measuredValue;

  public MaintenanceTaskRequiredEvent(Object source, Long inspectionRecordId, Double measuredValue) {
    super(source);

    this.inspectionRecordId = inspectionRecordId;
    this.measuredValue = measuredValue;
  }
}
