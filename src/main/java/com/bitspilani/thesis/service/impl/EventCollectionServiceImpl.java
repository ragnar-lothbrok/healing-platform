package com.bitspilani.thesis.service.impl;

import com.bitspilani.thesis.events.DatabaseEvent;
import com.bitspilani.thesis.events.SFTPEvent;
import com.bitspilani.thesis.model.DBMonitoringEvent;
import com.bitspilani.thesis.model.SFTPMonitoringEvent;
import com.bitspilani.thesis.repository.DBMonitoringEventRepository;
import com.bitspilani.thesis.repository.SFTPMonitoringEventRepository;
import com.bitspilani.thesis.service.EventCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EventCollectionServiceImpl implements EventCollectionService {

    @Autowired
    private DBMonitoringEventRepository dbMonitoringEventRepository;

    @Autowired
    private SFTPMonitoringEventRepository sftpMonitoringEventRepository;

    @Override
    public DBMonitoringEvent saveDBMonitoringEvent(DatabaseEvent databaseEvent) {
        return dbMonitoringEventRepository.save(DBMonitoringEvent.builder()
                .spaceAllocated(databaseEvent.getSpaceAllocated())
                .spaceUsed(databaseEvent.getSpaceUsed())
                .eventTimestamp(databaseEvent.getEventTimestamp())
                .instanceIdentifier(databaseEvent.getInstanceIdentifier())
                .createdBy("SYSTEM")
                .updatedBy("SYSTEM")
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build());
    }

    @Override
    public SFTPMonitoringEvent saveSFTPMonitoringEvent(SFTPEvent sftpEvent) {
        return sftpMonitoringEventRepository.save(SFTPMonitoringEvent.builder()
                .diskSpaceUsed(sftpEvent.getDiskSpaceUsed())
                .diskSpaceAllocated(sftpEvent.getDiskSpaceAllocated())
                .eventTimestamp(sftpEvent.getEventTimestamp())
                .instanceIdentifier(sftpEvent.getInstanceIdentifier())
                .createdBy("SYSTEM")
                .updatedBy("SYSTEM")
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build());
    }
}
