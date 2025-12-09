package com.plassertheurer.platform.u20231b475.inspections.interfaces.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plassertheurer.platform.u20231b475.inspections.domain.services.InspectionRecordCommandService;
import com.plassertheurer.platform.u20231b475.inspections.interfaces.rest.resources.CreateInspectionRecordResource;
import com.plassertheurer.platform.u20231b475.inspections.interfaces.rest.resources.InspectionRecordResource;
import com.plassertheurer.platform.u20231b475.inspections.interfaces.rest.transform.CreateInspectionRecordCommandFromResourceAssembler;
import com.plassertheurer.platform.u20231b475.inspections.interfaces.rest.transform.InspectionRecordResourceFromEntityAssembler;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/inspection-records")
@Tag(name = "Inspection Records controller")
public class InspectionRecordsController {
  private final InspectionRecordCommandService service;

  public InspectionRecordsController(InspectionRecordCommandService service) {
    this.service = service;
  }

  @PostMapping
  @Operation(summary = "Creates a new inspection Records")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Inspection record created"),
      @ApiResponse(responseCode = "400", description = "Bad requests")
  })
  public ResponseEntity<InspectionRecordResource> createInspectionRecord(
      @Valid @RequestBody CreateInspectionRecordResource resource) {
    var createInspectionRecordCommand = CreateInspectionRecordCommandFromResourceAssembler
        .toCommandFromResource(resource);

    var inspectionRecord = service.handle(createInspectionRecordCommand);

    if (inspectionRecord.isEmpty())
      return ResponseEntity.notFound().build();

    var createInspectionRecord = inspectionRecord.get();

    var inspectionRecordResource = InspectionRecordResourceFromEntityAssembler
        .toResourceFromEntity(createInspectionRecord);

    return new ResponseEntity<>(inspectionRecordResource, HttpStatus.CREATED);
  }
}
