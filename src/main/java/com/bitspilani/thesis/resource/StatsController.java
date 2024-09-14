package com.bitspilani.thesis.resource;

import com.bitspilani.thesis.dto.DiskSpaceDto;
import com.bitspilani.thesis.utils.DiskSpaceUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatsController {

    @GetMapping("/stats")
    public DiskSpaceDto getStats() {
        return DiskSpaceUtil.getDiskSpace();
    }
}
