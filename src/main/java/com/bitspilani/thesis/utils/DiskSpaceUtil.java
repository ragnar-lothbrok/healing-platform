package com.bitspilani.thesis.utils;

import com.bitspilani.thesis.events.SFTPEvent;
import com.bitspilani.thesis.model.DBMonitoringEvent;
import com.bitspilani.thesis.model.SFTPMonitoringEvent;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.Collectors;

public class DiskSpaceUtil {

    public static SFTPEvent getDiskSpace() {
        return Arrays.stream(File.listRoots()).map(file -> SFTPEvent.builder().diskSpaceUsed(file.getTotalSpace()- file.getFreeSpace()).diskSpaceAllocated(file.getTotalSpace()).eventTimestamp(LocalDateTime.now()).instanceIdentifier(file.getAbsolutePath()).build()).findFirst().get();
    }
}
