package com.bitspilani.thesis.resource;

import com.bitspilani.thesis.dto.events.DatabaseStorageEventDtoDto;
import com.bitspilani.thesis.dto.events.HTTPHealthEventDto;
import com.bitspilani.thesis.dto.events.SFTPStorageEventDto;
import com.bitspilani.thesis.service.IngestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/events")
public class IngestionController {

    @Autowired
    private IngestionService ingestionService;

    @PostMapping("/db-size")
    public ResponseEntity<Object> insertDatabaseStorageEvent(@RequestBody DatabaseStorageEventDtoDto databaseStorageEventDto) {
        ingestionService.insertDatabaseStorageEvent(databaseStorageEventDto);
        return ResponseEntity.ok("Event inserted successfully");
    }

    @PostMapping("/sftp")
    public ResponseEntity<Object> insertSFTPStorageEvent(@RequestBody SFTPStorageEventDto sftpStorageEvent) {
        ingestionService.insertSFTPStorageEvent(sftpStorageEvent);
        return ResponseEntity.ok("Event inserted successfully");
    }

    @PostMapping("/http")
    public ResponseEntity<Object> insertHttpHealthEvent(@RequestBody HTTPHealthEventDto httpHealthEvent) {
        ingestionService.insertHttpHealthEvent(httpHealthEvent);
        return ResponseEntity.ok("Event inserted successfully");
    }
}
