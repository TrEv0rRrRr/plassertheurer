package com.plassertheurer.platform.u20231b475.monitoring.interfaces.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plassertheurer.platform.u20231b475.monitoring.domain.model.queries.GetAllMaintenanceTasksQuery;
import com.plassertheurer.platform.u20231b475.monitoring.domain.services.MaintenanceTaskQueryService;
import com.plassertheurer.platform.u20231b475.monitoring.interfaces.rest.resources.MaintenanceTaskResource;
import com.plassertheurer.platform.u20231b475.monitoring.interfaces.rest.transform.MaintenanceTaskResourceFromEntityAssembler;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/api/v1/maintenance-tasks", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Maintenance Tasks", description = "Available maintenance tasks")
public class MaintenanceTasksController {
  private final MaintenanceTaskQueryService service;

  public MaintenanceTasksController(MaintenanceTaskQueryService service) {
    this.service = service;
  }

  @GetMapping
  @Operation(summary = "Get all maintenance tasks")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Maintenance Task found"),
      @ApiResponse(responseCode = "404", description = "Not found")
  })
  public ResponseEntity<List<MaintenanceTaskResource>> getAllMaintenanceTasks() {
    var maintenanceTasks = service.handle(new GetAllMaintenanceTasksQuery());

    if (maintenanceTasks.isEmpty())
      return ResponseEntity.notFound().build();

    var maintenanceTaskResources = maintenanceTasks.stream()
        .map(MaintenanceTaskResourceFromEntityAssembler::toResourceFromEntity).toList();

    return ResponseEntity.ok(maintenanceTaskResources);
  }
}
