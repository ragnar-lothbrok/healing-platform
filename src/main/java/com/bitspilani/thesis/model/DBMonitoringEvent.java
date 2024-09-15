package com.bitspilani.thesis.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "db_monitoring_event")
public class DBMonitoringEvent extends AuditEvent{
    @Id
    private String id;
    private String instanceIdentifier;
    private double spaceAllocated;  // in bytes
    private double spaceUsed;  // in bytes
    private LocalDateTime eventTimestamp;
}
