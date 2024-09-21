package com.bitspilani.thesis.resource;

import com.bitspilani.thesis.model.AlertConfig;
import com.bitspilani.thesis.service.AlertConfigService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="Alert Config API", description="The Alert Config API can be used to get and save alert configurations")
@RestController
@RequestMapping("/api/alert")
public class AlertConfigController {

    @Autowired
    private AlertConfigService alertConfigService;

    @Operation(summary = "Get all alert configurations", description = "Get all alert configurations", tags = {"alert"}, operationId = "getAllAlertConfigs", responses = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Alert configurations retrieved successfully")}, method = "GET")
    @GetMapping("/config")
    public List<AlertConfig> getAllAlertConfigs() {
        return alertConfigService.getAllAlertConfigs();
    }

    @Operation(summary = "Save alert configuration", description = "Save alert configuration", tags = {"alert"}, operationId = "saveAlertConfig", responses = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Alert configuration saved successfully")}, method = "POST")
    @PostMapping("/config")
    public AlertConfig saveAlertConfig(@RequestBody AlertConfig alertConfig) {
        return alertConfigService.saveAlertConfig(alertConfig);
    }

}
