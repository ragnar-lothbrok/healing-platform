package com.bitspilani.thesis.service.impl;

import com.bitspilani.thesis.model.EventConfig;
import com.bitspilani.thesis.repository.EventConfigRepository;
import com.bitspilani.thesis.service.EventConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventConfigServiceImpl implements EventConfigService {

    @Autowired
    private EventConfigRepository eventConfigRepository;

    @Override
    public List<EventConfig> getAllEventConfigs() {
        return Streamable.of(eventConfigRepository.findAll()).toList();
    }

    @Override
    public EventConfig saveEventConfig(EventConfig eventConfig) {
        return eventConfigRepository.save(eventConfig);
    }
}
