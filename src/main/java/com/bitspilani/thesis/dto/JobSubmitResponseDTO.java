package com.bitspilani.thesis.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;

@Data
@Builder
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JobSubmitResponseDTO {
    /**
     * The job id
     */
    private String jobId;

    /**
     * The module name
     */
    private String moduleName;

    /**
     * Arguments to be passed to the module
     */
    private List<String> arguments;

    /**
     * List of key-value arguments/named arguments to be passed to the module
     */
    private Map<String, Object> kwArguments;

    /**
     * The hosts where the job was executed
     */
    private String hosts;

    /**
     * The status of the job
     */
    private Boolean success;

    /**
     * The cloud where the job was executed
     */
    private String cloud;

    /**
     * The region where the job was executed
     */
    private String cloudRegion;

    /**
     * The account id of the cloud where the job was executed
     */
    private String cloudAccountId;

    /**
     * The resource id of the cloud where the job was executed
     */
    private String cloudResourceId;
}
