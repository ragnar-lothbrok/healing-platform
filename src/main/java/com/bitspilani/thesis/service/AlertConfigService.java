package com.bitspilani.thesis.service;

import com.bitspilani.thesis.model.EventConfig;

import java.util.List;

public interface AlertConfigService {

    List<EventConfig> getAllAlertConfigs();

    EventConfig saveAlertConfig(EventConfig eventConfig);
}
