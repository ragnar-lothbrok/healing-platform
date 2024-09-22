package com.bitspilani.thesis.resource;

import com.bitspilani.thesis.dto.events.DatabaseStorageEventDtoDto;
import com.bitspilani.thesis.dto.events.HTTPHealthEventDto;
import com.bitspilani.thesis.dto.events.SFTPStorageEventDto;
import com.bitspilani.thesis.service.IngestionService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Tag(name = "Event API", description = "The Event API can be used to get event statistics")
@RestController
@RequestMapping("/api/events")
public class IngestionController {

    @Autowired
    private IngestionService ingestionService;

    @Operation(summary = "Insert database storage event", description = "Insert database storage event", tags = {"events"}, operationId = "insertDatabaseStorageEvent", responses = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Event inserted successfully")}, method = "POST")
    @PostMapping("/db-size")
    public ResponseEntity<Object> insertDatabaseStorageEvent(@RequestBody DatabaseStorageEventDtoDto databaseStorageEventDto) {
        ingestionService.insertDatabaseStorageEvent(databaseStorageEventDto);
        return ResponseEntity.ok("Event inserted successfully");
    }

    @Operation(summary = "Insert SFTP storage event", description = "Insert SFTP storage event", tags = {"events"}, operationId = "insertSFTPStorageEvent", responses = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Event inserted successfully")}, method = "POST")
    @PostMapping("/sftp")
    public ResponseEntity<Object> insertSFTPStorageEvent(@RequestBody SFTPStorageEventDto sftpStorageEvent) {
        ingestionService.insertSFTPStorageEvent(sftpStorageEvent);
        return ResponseEntity.ok("Event inserted successfully");
    }

    @Operation(summary = "Insert HTTP health event", description = "Insert HTTP health event", tags = {"events"}, operationId = "insertHttpHealthEvent", responses = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Event inserted successfully")}, method = "POST")
    @PostMapping("/http")
    public ResponseEntity<Object> insertHttpHealthEvent(@RequestBody HTTPHealthEventDto httpHealthEvent) {
        ingestionService.insertHttpHealthEvent(httpHealthEvent);
        return ResponseEntity.ok("Event inserted successfully");
    }
}
