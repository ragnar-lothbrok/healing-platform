package com.bitspilani.thesis.service.impl;

import com.bitspilani.thesis.dto.events.DatabaseStorageEventDtoDto;
import com.bitspilani.thesis.dto.events.HTTPHealthEventDto;
import com.bitspilani.thesis.dto.events.SFTPStorageEventDto;
import com.bitspilani.thesis.model.DatabaseStorageEvent;
import com.bitspilani.thesis.model.HttpHealthEvent;
import com.bitspilani.thesis.model.SFTPStorageEvent;
import com.bitspilani.thesis.repository.DBStorageEventRepository;
import com.bitspilani.thesis.repository.HttpHealthEventRepository;
import com.bitspilani.thesis.repository.SFTPStorageEventRepository;
import com.bitspilani.thesis.service.IngestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class IngestionServiceImpl implements IngestionService {

    @Autowired
    private DBStorageEventRepository dbStorageEventRepository;

    @Autowired
    private SFTPStorageEventRepository sftpStorageEventRepository;

    @Autowired
    private HttpHealthEventRepository httpHealthEventRepository;

    @Override
    public void insertDatabaseStorageEvent(DatabaseStorageEventDtoDto databaseStorageEventDto) {
        dbStorageEventRepository.save(DatabaseStorageEvent.builder()
                .collectorName(databaseStorageEventDto.getCollectorName())
                .collectorVersion(databaseStorageEventDto.getCollectorVersion())
                .eventType(databaseStorageEventDto.getEventType())
                .eventTimestamp(databaseStorageEventDto.getEventTimestamp())
                .databaseEndPoint(databaseStorageEventDto.getDatabaseEndPoint())
                .datasourceName(databaseStorageEventDto.getDatasourceName())
                .providerName(databaseStorageEventDto.getProviderName())
                .providerVersion(databaseStorageEventDto.getProviderVersion())
                .spaceAllocated(databaseStorageEventDto.getSpaceAllocated())
                .spaceUsed(databaseStorageEventDto.getSpaceUsed())
                .collectorOperatingSystem(databaseStorageEventDto.getCollectorOperatingSystem())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .createdBy("admin")
                .updatedBy("admin")
                .build());
    }

    @Override
    public void insertSFTPStorageEvent(SFTPStorageEventDto sftpStorageEvent) {
        sftpStorageEventRepository.save(SFTPStorageEvent.builder()
                .collectorName(sftpStorageEvent.getCollectorName())
                .collectorVersion(sftpStorageEvent.getCollectorVersion())
                .eventType(sftpStorageEvent.getEventType())
                .eventTimestamp(sftpStorageEvent.getEventTimestamp())
                .hostIdentifier(sftpStorageEvent.getHostIdentifier())
                .diskSpaceAllocated(sftpStorageEvent.getDiskSpaceAllocated())
                .diskSpaceUsed(sftpStorageEvent.getDiskSpaceUsed())
                .diskPath(sftpStorageEvent.getDiskPath())
                        .collectorOperatingSystem(sftpStorageEvent.getCollectorOperatingSystem())
                        .createdAt(LocalDateTime.now())
                        .updatedAt(LocalDateTime.now())
                        .createdBy("admin")
                        .updatedBy("admin")
                .build());
    }

    @Override
    public void insertHttpHealthEvent(HTTPHealthEventDto httpHealthEvent) {
        httpHealthEventRepository.save(HttpHealthEvent.builder()
                .collectorName(httpHealthEvent.getCollectorName())
                .collectorVersion(httpHealthEvent.getCollectorVersion())
                .eventType(httpHealthEvent.getEventType())
                .eventTimestamp(httpHealthEvent.getEventTimestamp())
                .hostIdentifier(httpHealthEvent.getHostIdentifier())
                .collectorOperatingSystem(httpHealthEvent.getCollectorOperatingSystem())
                .targetServiceEndPoint(httpHealthEvent.getTargetServiceEndPoint())
                .targetServiceName(httpHealthEvent.getTargetServiceName())
                .statusCode(httpHealthEvent.getStatusCode())
                .statusMessage(httpHealthEvent.getStatusMessage())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .createdBy("admin")
                .updatedBy("admin")
                .build());
    }
}
