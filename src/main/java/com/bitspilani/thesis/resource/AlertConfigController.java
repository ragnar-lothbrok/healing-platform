package com.bitspilani.thesis.resource;

import com.bitspilani.thesis.model.AlertConfig;
import com.bitspilani.thesis.service.AlertConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlertConfigController {

    @Autowired
    private AlertConfigService alertConfigService;

    @GetMapping("/alert-configs")
    public List<AlertConfig> getAllAlertConfigs() {
        return alertConfigService.getAllAlertConfigs();
    }

    @PostMapping("/alert-configs")
    public AlertConfig saveAlertConfig(@RequestBody AlertConfig alertConfig) {
        return alertConfigService.saveAlertConfig(alertConfig);
    }

}
