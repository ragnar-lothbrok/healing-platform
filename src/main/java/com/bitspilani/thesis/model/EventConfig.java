package com.bitspilani.thesis.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "event_config")
public class EventConfig {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String eventType;            // Type of event
    private String hostIdentifier;       // Host machine identifier
    private boolean isEnabled;           // Is the event enabled?
    private String frequency;            // Frequency of event generation
    private LocalDateTime lastExecuted;  // Last execution timestamp

    private String moduleName;           // Module responsible for generating the event
    private String moduleVersion;        // Version of the module
    private String invokeMethod;         // Method to invoke for event generation

    private String createdBy;            // User who created the configuration
    private LocalDateTime createdDate;   // Creation timestamp
    private String modifiedBy;           // User who last modified the configuration
    private LocalDateTime modifiedDate;  // Last modified timestamp

    // Additional fields
    private int retryAttempts;           // Number of retry attempts
    private int timeout;                 // Timeout for event generation
    private String notificationSettings; // Alert/notification settings
}
