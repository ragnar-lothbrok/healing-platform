package com.bitspilani.thesis.service.impl;

import com.bitspilani.thesis.model.DatabaseStorageEvent;
import com.bitspilani.thesis.model.HttpHealthEvent;
import com.bitspilani.thesis.model.SFTPStorageEvent;
import com.bitspilani.thesis.repository.DBStorageEventRepository;
import com.bitspilani.thesis.repository.HttpHealthEventRepository;
import com.bitspilani.thesis.repository.SFTPStorageEventRepository;
import com.bitspilani.thesis.service.ReportingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportingServiceImpl implements ReportingService {

    @Autowired
    private DBStorageEventRepository dbStorageEventRepository;

    @Autowired
    private SFTPStorageEventRepository sftpStorageEventRepository;

    @Autowired
    private HttpHealthEventRepository httpHealthEventRepository;

    @Override
    public List<DatabaseStorageEvent> getDatabaseStorageEvents() {
        return dbStorageEventRepository.findAll();
    }

    @Override
    public List<SFTPStorageEvent> getSFTPStorageEvents() {
        return sftpStorageEventRepository.findAll();
    }

    @Override
    public List<HttpHealthEvent> getHttpHealthEvents() {
        return httpHealthEventRepository.findAll();
    }
}
