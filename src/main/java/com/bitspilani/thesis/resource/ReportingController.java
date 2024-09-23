package com.bitspilani.thesis.resource;

import com.bitspilani.thesis.model.DatabaseStorageEvent;
import com.bitspilani.thesis.model.HttpHealthEvent;
import com.bitspilani.thesis.model.SFTPStorageEvent;
import com.bitspilani.thesis.service.ReportingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/report")
public class ReportingController {

    @Autowired
    private ReportingService eventReportingService;

    @GetMapping("/db")
    public ResponseEntity<List<DatabaseStorageEvent>> getDatabaseStorageEvents() {
        return ResponseEntity.ok(eventReportingService.getDatabaseStorageEvents());
    }

    @GetMapping("/sftp")
    public ResponseEntity<List<SFTPStorageEvent>> getSFTPStorageEvents() {
        return ResponseEntity.ok(eventReportingService.getSFTPStorageEvents());
    }

    @GetMapping("/http")
    public ResponseEntity<List<HttpHealthEvent>> getHttpHealthEvents() {
        return ResponseEntity.ok(eventReportingService.getHttpHealthEvents());
    }
}
