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
@Document(collection = "sftp_monitoring_event")
public class SFTPMonitoringEvent extends AuditEvent{
    @Id
    private String id;
    private String instanceIdentifier;
    private double diskSpaceAllocated;  // in bytes
    private double diskSpaceUsed;  // in bytes
    private LocalDateTime eventTimestamp;
}
