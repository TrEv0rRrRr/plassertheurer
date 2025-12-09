package com.plassertheurer.platform.u20231b475.inspections.domain.model.events;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;

@Getter
public class MaintenanceTaskRequiredEvent extends ApplicationEvent {
  private String vehicleCode;
  private String parameter;
  private Long inspectionRecordId;
  private Double measuredValue;
  private Double minAcceptableValue;
  private Double maxAcceptableValue;

  public MaintenanceTaskRequiredEvent(Object source, Long inspectionRecordId, Double measuredValue,
      Double minAcceptableValue,
      Double maxAcceptableValue,
      String vehicleCode,
      String parameter) {
    super(source);

    this.inspectionRecordId = inspectionRecordId;
    this.measuredValue = measuredValue;
    this.minAcceptableValue = minAcceptableValue;
    this.maxAcceptableValue = maxAcceptableValue;
    this.vehicleCode = vehicleCode;
    this.parameter = parameter;
  }
}
