package com.bitspilani.thesis.service.impl;

import com.bitspilani.thesis.events.SFTPEvent;
import com.bitspilani.thesis.model.DBMonitoringEvent;
import com.bitspilani.thesis.model.SFTPMonitoringEvent;
import com.bitspilani.thesis.repository.DBMonitoringEventRepository;
import com.bitspilani.thesis.repository.SFTPMonitoringEventRepository;
import com.bitspilani.thesis.service.EventReportingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventReportingServiceImpl implements EventReportingService {

    @Autowired
    private DBMonitoringEventRepository dbMonitoringEventRepository;

    @Autowired
    private SFTPMonitoringEventRepository sftpMonitoringEventRepository;

    @Override
    public List<DBMonitoringEvent> getDBMonitoringEvents() {
        return dbMonitoringEventRepository.findAll();
    }

    @Override
    public List<SFTPMonitoringEvent> getSFTPEvents() {
        return sftpMonitoringEventRepository.findAll();
    }
}
