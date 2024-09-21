package com.bitspilani.thesis.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;

@Data
@Accessors(chain = true)
public class JobSubmitRequestDTO {
    @Schema(
            required = true,
            description =
                    "The module name")
    private String moduleName;

    @Schema(description = "Arguments to be passed to the module")
    private List<String> arguments;

    @Schema(description = "List of key-value arguments/named arguments to be passed to the module")
    private Map<String, Object> kwArguments;

    @Schema(
            required = true,
            description =
                    "host machines or server")
    private String hosts;
}
