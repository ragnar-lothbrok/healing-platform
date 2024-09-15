package com.bitspilani.thesis.schedulingtasks;

import com.bitspilani.thesis.service.EventCollectionService;
import com.bitspilani.thesis.utils.DiskSpaceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class ScheduledMetricCollectionEventTask {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private EventCollectionService eventCollectionService;

    @Scheduled(fixedRate = 60000)
    public void invokeDatabaseMonitoring() {

    }

    @Scheduled(fixedRate = 60000)
    public void invokeSFTPMonitoring() {
        eventCollectionService.saveSFTPMonitoringEvent(DiskSpaceUtil.getDiskSpace());
    }
}
