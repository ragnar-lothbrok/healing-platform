package com.bitspilani.thesis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "http_health_events")
public class HttpHealthEvent extends AuditEvent {

    private String collectorName;        // Monitoring agent name
    private String collectorVersion;     // Monitoring agent version
    private String eventType;            // Type of event (e.g., DB_USAGE, HTTP_HEALTH)
    private LocalDateTime eventTimestamp; // Timestamp of the event
    private String hostIdentifier;     // EC2 instance ID
    private Map<String,String> collectorOperatingSystem;     // Linux
    private String targetServiceEndPoint;           // URL
    private String targetServiceName;               // Service name
    private Integer statusCode;         // 200
    private String statusMessage;       // OK
}
