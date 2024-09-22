package com.bitspilani.thesis.dto.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public abstract class HealthEventDto {
    private String collectorName;        // Monitoring agent name
    private String collectorVersion;     // Monitoring agent version
    private String eventType;            // Type of event (e.g., DB_USAGE, HTTP_HEALTH)
    private LocalDateTime eventTimestamp; // Timestamp of the event
    private Map<String,String> collectorOperatingSystem;     // Linux
}
