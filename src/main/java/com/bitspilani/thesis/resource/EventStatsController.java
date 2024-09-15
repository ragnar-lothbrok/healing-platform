package com.bitspilani.thesis.resource;

import com.bitspilani.thesis.service.EventReportingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventStatsController {

    @Autowired
    private EventReportingService eventReportingService;

    @GetMapping("/stats/events/db")
    public ResponseEntity<Object> getDBEvents() {
        return ResponseEntity.ok(eventReportingService.getDBMonitoringEvents());
    }

    @GetMapping("/stats/events/sftp")
    public ResponseEntity<Object> getSFTPEvents() {
        return ResponseEntity.ok(eventReportingService.getSFTPEvents());
    }
}
