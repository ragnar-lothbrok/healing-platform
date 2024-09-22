package com.bitspilani.thesis.service.impl;

import com.bitspilani.thesis.model.EventConfig;
import com.bitspilani.thesis.repository.AlertConfigRepository;
import com.bitspilani.thesis.service.AlertConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertConfigServiceImpl implements AlertConfigService {

    @Autowired
    private AlertConfigRepository alertConfigRepository;

    @Override
    public List<EventConfig> getAllAlertConfigs() {
        return Streamable.of(alertConfigRepository.findAll()).toList();
    }

    @Override
    public EventConfig saveAlertConfig(EventConfig eventConfig) {
        return alertConfigRepository.save(eventConfig);
    }
}
