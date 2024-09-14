package com.bitspilani.thesis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "db_storage_events")
public class DatabaseStorageEvent extends AuditEvent {
    @Id
    private String id;
    private String databaseEndPoint; // URL
    private String datasourceName;    // RDS
    private String providerName;      // Postgres
    private String providerVersion;   // 14.10
    private double spaceAllocated;     // in bytes
    private double spaceUsed;          // in bytes
    private String collectorName;        // Monitoring agent name
    private String collectorVersion;     // Monitoring agent version
    private String eventType;            // Type of event (e.g., DB_USAGE, HTTP_HEALTH)
    private LocalDateTime eventTimestamp; // Timestamp of the event
    private Map<String,String> collectorOperatingSystem;     // Linux
}
