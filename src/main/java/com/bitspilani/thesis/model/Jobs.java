package com.bitspilani.thesis.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "jobs")
public class Jobs extends AuditEvent {
    @Id
    private String jobId;

    private String moduleName;

    private List<String> arguments;

    private Map<String, Object> kwArguments;

    private String targetHosts;

    private boolean success;

    private String cloud;

    private String cloudRegion;

    private String cloudAccountId;

    private String cloudResourceId;
}
