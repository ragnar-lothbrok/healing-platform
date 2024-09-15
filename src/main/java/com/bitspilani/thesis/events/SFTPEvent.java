package com.bitspilani.thesis.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SFTPEvent {
    private String instanceIdentifier;
    private double diskSpaceAllocated;  // in bytes
    private double diskSpaceUsed;  // in bytes
    private LocalDateTime eventTimestamp;
}
