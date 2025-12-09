package com.plassertheurer.platform.u20231b475.inspections.domain.services;

import java.util.Optional;

import com.plassertheurer.platform.u20231b475.inspections.domain.model.aggregates.InspectionRecord;
import com.plassertheurer.platform.u20231b475.inspections.domain.model.commands.CreateInspectionRecordCommand;

public interface InspectionRecordCommandService {
  Optional<InspectionRecord> handle(CreateInspectionRecordCommand command);
}
