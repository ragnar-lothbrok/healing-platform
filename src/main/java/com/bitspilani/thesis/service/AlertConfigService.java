package com.bitspilani.thesis.service;

import com.bitspilani.thesis.model.AlertConfig;

import java.util.List;

public interface AlertConfigService {

    List<AlertConfig> getAllAlertConfigs();

    AlertConfig saveAlertConfig(AlertConfig alertConfig);
}
