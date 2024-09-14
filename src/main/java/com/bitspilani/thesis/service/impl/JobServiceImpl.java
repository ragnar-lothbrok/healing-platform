package com.bitspilani.thesis.service.impl;

import com.bitspilani.thesis.dto.JobSubmitRequestDTO;
import com.bitspilani.thesis.dto.JobSubmitResponseDTO;
import com.bitspilani.thesis.model.Jobs;
import com.bitspilani.thesis.repository.JobRepository;
import com.bitspilani.thesis.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Override
    public JobSubmitResponseDTO submitJob(JobSubmitRequestDTO jobSubmitRequestDTO) {
        Jobs job = jobRepository.save(Jobs.builder()
                        .kwArguments(jobSubmitRequestDTO.getKwArguments())
                        .jobId(UUID.randomUUID().toString())
                        .moduleName(jobSubmitRequestDTO.getModuleName())
                        .targetHosts(jobSubmitRequestDTO.getHosts())
                        .arguments(jobSubmitRequestDTO.getArguments())
                        .success(false)
                .createdBy("SYSTEM")
                .updatedBy("SYSTEM")
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build());
        return JobSubmitResponseDTO.builder()
                .jobId(job.getJobId())
                .success(job.isSuccess())
                .moduleName(job.getModuleName())
                .arguments(job.getArguments())
                .kwArguments(job.getKwArguments())
                .hosts(job.getTargetHosts())
                .cloud(job.getCloud())
                .cloudRegion(job.getCloudRegion())
                .cloudAccountId(job.getCloudAccountId())
                .cloudResourceId(job.getCloudResourceId())
                .build();
    }

    @Override
    public JobSubmitResponseDTO getJobStatus(String jobId) {
        Jobs job = jobRepository.findById(jobId).orElseThrow(() -> new RuntimeException(String.format("Job %s not found", jobId)));
        return JobSubmitResponseDTO.builder()
                .jobId(job.getJobId())
                .success(job.isSuccess())
                .moduleName(job.getModuleName())
                .arguments(job.getArguments())
                .kwArguments(job.getKwArguments())
                .hosts(job.getTargetHosts())
                .cloud(job.getCloud())
                .cloudRegion(job.getCloudRegion())
                .cloudAccountId(job.getCloudAccountId())
                .cloudResourceId(job.getCloudResourceId())
                .build();
    }
}
