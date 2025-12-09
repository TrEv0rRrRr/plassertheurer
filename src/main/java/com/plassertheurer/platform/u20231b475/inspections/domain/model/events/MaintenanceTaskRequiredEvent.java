package com.plassertheurer.platform.u20231b475.inspections.domain.model.events;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;

@Getter
public class MaintenanceTaskRequiredEvent extends ApplicationEvent {
  private Long inspectionRecordId;
  private Double measuredValue;
  private Double maxAcceptableValue;

  public MaintenanceTaskRequiredEvent(Object source, Long inspectionRecordId, Double measuredValue,
      Double maxAcceptableValue) {
    super(source);

    this.inspectionRecordId = inspectionRecordId;
    this.measuredValue = measuredValue;
    this.maxAcceptableValue = maxAcceptableValue;
  }
}
