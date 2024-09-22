package com.bitspilani.thesis.resource;

import com.bitspilani.thesis.model.DatabaseStorageEvent;
import com.bitspilani.thesis.model.HttpHealthEvent;
import com.bitspilani.thesis.model.SFTPStorageEvent;
import com.bitspilani.thesis.service.ReportingService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@Tag(name = "Event API", description = "The Event API can be used to get event statistics")
@RestController
@RequestMapping("/api/report")
public class ReportingController {

    @Autowired
    private ReportingService eventReportingService;

    @Operation(summary = "Get database events", description = "Get all database events", tags = {"stats"}, operationId = "getDatabaseEvents", responses = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Database events retrieved successfully")}, method = "GET")
    @GetMapping("/db")
    public ResponseEntity<List<DatabaseStorageEvent>> getDatabaseStorageEvents() {
        return ResponseEntity.ok(eventReportingService.getDatabaseStorageEvents());
    }

    @Operation(summary = "Get SFTP events", description = "Get all SFTP events", tags = {"stats"}, operationId = "getSFTPEvents", responses = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "SFTP events retrieved successfully")}, method = "GET")
    @GetMapping("/sftp")
    public ResponseEntity<List<SFTPStorageEvent>> getSFTPStorageEvents() {
        return ResponseEntity.ok(eventReportingService.getSFTPStorageEvents());
    }

    @Operation(summary = "Get SFTP events", description = "Get all SFTP events", tags = {"stats"}, operationId = "getSFTPEvents", responses = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "SFTP events retrieved successfully")}, method = "GET")
    @GetMapping("/http")
    public ResponseEntity<List<HttpHealthEvent>> getHttpHealthEvents() {
        return ResponseEntity.ok(eventReportingService.getHttpHealthEvents());
    }
}
