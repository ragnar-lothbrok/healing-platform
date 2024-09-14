package com.bitspilani.thesis.service;

import com.bitspilani.thesis.model.EventConfig;

import java.util.List;

public interface EventConfigService {

    List<EventConfig> getAllEventConfigs();

    EventConfig saveEventConfig(EventConfig eventConfig);
}
