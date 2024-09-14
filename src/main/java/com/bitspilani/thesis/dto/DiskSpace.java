package com.bitspilani.thesis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder(toBuilder = true)
@AllArgsConstructor
public class DiskSpace {
    private String root;
    private long freeSpace;
    private long totalSpace;
}
