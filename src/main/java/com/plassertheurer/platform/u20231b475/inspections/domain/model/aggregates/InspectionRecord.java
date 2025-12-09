package com.plassertheurer.platform.u20231b475.inspections.domain.model.aggregates;

import com.plassertheurer.platform.u20231b475.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import jakarta.persistence.Entity;
import lombok.Getter;

@Entity
@Getter
public class InspectionRecord extends AuditableAbstractAggregateRoot<InspectionRecord> {

}
