package com.bitspilani.thesis.utils;

import com.bitspilani.thesis.dto.events.SFTPStorageEventDto;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Arrays;

public class DiskSpaceUtil {

    public static SFTPStorageEventDto getDiskSpace() {
        return Arrays.stream(File.listRoots()).map(file -> SFTPStorageEventDto.builder().diskSpaceUsed(file.getTotalSpace()- file.getFreeSpace()).diskSpaceAllocated(file.getTotalSpace()).eventTimestamp(LocalDateTime.now()).diskPath(file.getAbsolutePath()).build()).findFirst().get();
    }
}
