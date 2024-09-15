package com.bitspilani.thesis.service;

import com.bitspilani.thesis.events.SFTPEvent;
import com.bitspilani.thesis.model.DBMonitoringEvent;
import com.bitspilani.thesis.model.SFTPMonitoringEvent;

import java.util.List;

public interface EventReportingService {

    List<DBMonitoringEvent> getDBMonitoringEvents();

    List<SFTPMonitoringEvent> getSFTPEvents();
}
