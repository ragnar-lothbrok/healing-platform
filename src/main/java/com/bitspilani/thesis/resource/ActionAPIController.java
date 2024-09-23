package com.bitspilani.thesis.resource;

import com.bitspilani.thesis.dto.JobSubmitRequestDTO;
import com.bitspilani.thesis.dto.JobSubmitResponseDTO;
import com.bitspilani.thesis.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/jobs")
public class ActionAPIController {

    @Autowired
    private JobService jobService;

    @PostMapping("/submit")
    public JobSubmitResponseDTO submitJob(@RequestBody JobSubmitRequestDTO jobSubmitRequestDTO) {
        return jobService.submitJob(jobSubmitRequestDTO);
    }

    @GetMapping("/{jobId}")
    public JobSubmitResponseDTO getJobStatus(@PathVariable("jobId") String jobId) {
        return jobService.getJobStatus(jobId);
    }

}
