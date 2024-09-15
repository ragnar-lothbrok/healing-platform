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
public class DatabaseEvent {
    private String instanceIdentifier;
    private double spaceAllocated;  // in bytes
    private double spaceUsed;  // in bytes
    private LocalDateTime eventTimestamp;
}
