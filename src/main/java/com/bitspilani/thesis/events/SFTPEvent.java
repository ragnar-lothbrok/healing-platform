package com.bitspilani.thesis.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class SFTPEvent extends HealthEvent {
    private String hostIdentifier;      // EC2 instance ID
    private double diskSpaceAllocated;   // in bytes
    private double diskSpaceUsed;        // in bytes
    private String diskPath;             // /home/user/sftp
}
