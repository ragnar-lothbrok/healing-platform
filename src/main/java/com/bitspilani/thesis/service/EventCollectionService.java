package com.bitspilani.thesis.service;

import com.bitspilani.thesis.events.SFTPEvent;
import com.bitspilani.thesis.model.DBMonitoringEvent;
import com.bitspilani.thesis.model.SFTPMonitoringEvent;

public interface EventCollectionService {

    DBMonitoringEvent saveDBMonitoringEvent(DBMonitoringEvent dbMonitoringEvent);

    SFTPMonitoringEvent saveSFTPMonitoringEvent(SFTPEvent sftpEvent);
}
