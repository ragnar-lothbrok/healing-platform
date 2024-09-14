package com.bitspilani.thesis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Builder(toBuilder = true)
@AllArgsConstructor
public class DiskSpaceDto {
    private List<DiskSpace> diskSpaces;
}
