package com.bitspilani.thesis.utils;

import com.bitspilani.thesis.dto.DiskSpace;
import com.bitspilani.thesis.dto.DiskSpaceDto;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Collectors;

public class DiskSpaceUtil {

    public static DiskSpaceDto getDiskSpace() {
        return DiskSpaceDto.builder().diskSpaces(Arrays.stream(File.listRoots()).map(file -> new DiskSpace(file.getAbsolutePath(), file.getFreeSpace(), file.getTotalSpace())).collect(Collectors.toList())).build();
    }
}
