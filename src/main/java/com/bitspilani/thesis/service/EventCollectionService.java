package com.bitspilani.thesis.service;

import com.bitspilani.thesis.events.DatabaseEvent;
import com.bitspilani.thesis.events.SFTPEvent;
import com.bitspilani.thesis.model.DBMonitoringEvent;
import com.bitspilani.thesis.model.SFTPMonitoringEvent;

public interface EventCollectionService {

    DBMonitoringEvent saveDBMonitoringEvent(DatabaseEvent databaseEvent);

    SFTPMonitoringEvent saveSFTPMonitoringEvent(SFTPEvent sftpEvent);
}
