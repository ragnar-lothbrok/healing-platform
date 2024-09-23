package com.bitspilani.thesis.resource;

import com.bitspilani.thesis.model.EventConfig;
import com.bitspilani.thesis.service.EventConfigService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@Tag(name="Alert Config API", description="The Alert Config API can be used to get and save alert configurations")
@RestController
@RequestMapping("/api/eventconfig")
public class EventConfigController {

    @Autowired
    private EventConfigService eventConfigService;

    @Operation(summary = "Get all alert configurations", description = "Get all alert configurations", tags = {"alert"}, operationId = "getAllAlertConfigs", responses = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Alert configurations retrieved successfully")}, method = "GET")
    public List<EventConfig> getAllEventConfigs() {
        return eventConfigService.getAllEventConfigs();
    }

    @Operation(summary = "Save alert configuration", description = "Save alert configuration", tags = {"alert"}, operationId = "saveAlertConfig", responses = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Alert configuration saved successfully")}, method = "POST")
    @PostMapping("/config")
    public EventConfig saveEventConfig(@RequestBody EventConfig eventConfig) {
        return eventConfigService.saveEventConfig(eventConfig);
    }

}
