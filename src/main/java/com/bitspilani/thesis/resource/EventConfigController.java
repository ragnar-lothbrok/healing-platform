package com.bitspilani.thesis.resource;

import com.bitspilani.thesis.model.EventConfig;
import com.bitspilani.thesis.service.EventConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventconfig")
public class EventConfigController {

    @Autowired
    private EventConfigService eventConfigService;

    @GetMapping("/config")
    public List<EventConfig> getAllEventConfigs() {
        return eventConfigService.getAllEventConfigs();
    }

    @PostMapping("/config")
    public EventConfig saveEventConfig(@RequestBody EventConfig eventConfig) {
        return eventConfigService.saveEventConfig(eventConfig);
    }

}
