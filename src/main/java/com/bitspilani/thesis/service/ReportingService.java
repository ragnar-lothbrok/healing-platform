package com.bitspilani.thesis.service;

import com.bitspilani.thesis.model.DatabaseStorageEvent;
import com.bitspilani.thesis.model.HttpHealthEvent;
import com.bitspilani.thesis.model.SFTPStorageEvent;

import java.util.List;

public interface ReportingService {

    List<DatabaseStorageEvent> getDatabaseStorageEvents();

    List<SFTPStorageEvent> getSFTPStorageEvents();

    List<HttpHealthEvent> getHttpHealthEvents();
}
