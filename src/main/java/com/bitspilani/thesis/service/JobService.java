package com.bitspilani.thesis.service;

import com.bitspilani.thesis.dto.JobSubmitRequestDTO;
import com.bitspilani.thesis.dto.JobSubmitResponseDTO;

public interface JobService {
    JobSubmitResponseDTO submitJob(JobSubmitRequestDTO jobSubmitRequestDTO);

    JobSubmitResponseDTO getJobStatus(String jobId);
}
