package com.bitspilani.thesis.dto.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class SFTPStorageEventDto extends HealthEventDto {
    private String hostIdentifier;      // EC2 instance ID
    private double diskSpaceAllocated;   // in bytes
    private double diskSpaceUsed;        // in bytes
    private String diskPath;             // /home/user/sftp
}
