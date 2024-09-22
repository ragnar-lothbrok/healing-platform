package com.bitspilani.thesis.service;

import com.bitspilani.thesis.dto.events.DatabaseStorageEventDtoDto;
import com.bitspilani.thesis.dto.events.HTTPHealthEventDto;
import com.bitspilani.thesis.dto.events.SFTPStorageEventDto;

public interface IngestionService {

    void insertDatabaseStorageEvent(DatabaseStorageEventDtoDto databaseStorageEventDto);

    void insertSFTPStorageEvent(SFTPStorageEventDto sftpStorageEvent);

    void insertHttpHealthEvent(HTTPHealthEventDto httpHealthEvent);
}
