package com.bitspilani.thesis.resource;

import com.bitspilani.thesis.dto.JobSubmitRequestDTO;
import com.bitspilani.thesis.dto.JobSubmitResponseDTO;
import com.bitspilani.thesis.service.JobService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@Tag(name="Jobs API", description = "The Jobs API can be used to submit and get job")
@RestController
@RequestMapping("/jobs")
public class ActionAPIController {

    @Autowired
    private JobService jobService;

    @Operation(summary = "Submit a job", description = "Submit a job to be executed", tags = {"jobs"}, operationId = "submitJob", responses = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Job submitted successfully"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Invalid input"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "409", description = "Job already exists")}, requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = JobSubmitRequestDTO.class))), method = "POST")
    @PostMapping("/submit")
    public JobSubmitResponseDTO submitJob(@RequestBody JobSubmitRequestDTO jobSubmitRequestDTO) {
        return jobService.submitJob(jobSubmitRequestDTO);
    }

    @Operation(summary = "Get job status", description = "Get the status of a job", tags = {"jobs"}, operationId = "getJobStatus", responses = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Job status retrieved successfully"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Job not found")}, method = "GET")
    @GetMapping("/{jobId}")
    public JobSubmitResponseDTO getJobStatus(@PathVariable("jobId") String jobId) {
        return jobService.getJobStatus(jobId);
    }

}
