package com.bitspilani.thesis.dto.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class DatabaseStorageEventDtoDto extends HealthEventDto {
    private String databaseEndPoint; // URL
    private String datasourceName;    // RDS
    private String providerName;      // Postgres
    private String providerVersion;   // 14.10
    private double spaceAllocated;     // in bytes
    private double spaceUsed;          // in bytes
}
