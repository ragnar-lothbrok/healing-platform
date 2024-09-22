package com.bitspilani.thesis.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Map;

@Data
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class HTTPHealthEvent extends HealthEvent {
    private String hostIdentifier;     // EC2 instance ID
    private Map<String,String> operatingSystem;     // Linux
    private String agentName;           // Agent name
    private Integer statusCode;         // 200
    private String statusMessage;       // OK
}
