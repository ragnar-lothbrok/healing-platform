package com.bitspilani.thesis.dto.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class HTTPHealthEventDto extends HealthEventDto {
    private String hostIdentifier;     // EC2 instance ID
    private String targetServiceEndPoint;           // URL
    private String targetServiceName;               // Service name
    private Integer statusCode;         // 200
    private String statusMessage;       // OK
}
