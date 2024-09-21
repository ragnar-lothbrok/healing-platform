package com.bitspilani.thesis.resource;

import com.bitspilani.thesis.service.EventReportingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Event API", description = "The Event API can be used to get event statistics")
@RestController
@RequestMapping("/api/events")
public class EventStatsController {

    @Autowired
    private EventReportingService eventReportingService;

    @Operation(summary = "Get DB events", description = "Get all DB events", tags = {"stats"}, operationId = "getDBEvents", responses = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "DB events retrieved successfully")}, method = "GET")
    @GetMapping("/db")
    public ResponseEntity<Object> getDBEvents() {
        return ResponseEntity.ok(eventReportingService.getDBMonitoringEvents());
    }

    @Operation(summary = "Get SFTP events", description = "Get all SFTP events", tags = {"stats"}, operationId = "getSFTPEvents", responses = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "SFTP events retrieved successfully")}, method = "GET")
    @GetMapping("/sftp")
    public ResponseEntity<Object> getSFTPEvents() {
        return ResponseEntity.ok(eventReportingService.getSFTPEvents());
    }
}
