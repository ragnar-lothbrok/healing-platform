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
@Document(collection = "sftp_storage_events")
public class SFTPStorageEvent extends AuditEvent{
    @Id
    private String id;
    private String collectorName;        // Monitoring agent name
    private String collectorVersion;     // Monitoring agent version
    private String eventType;            // Type of event (e.g., DB_USAGE, HTTP_HEALTH)
    private LocalDateTime eventTimestamp; // Timestamp of the event
    private String hostIdentifier;      // EC2 instance ID
    private double diskSpaceAllocated;   // in bytes
    private double diskSpaceUsed;        // in bytes
    private String diskPath;             // /home/user/sftp
    private Map<String,String> collectorOperatingSystem;     // Linux
}
