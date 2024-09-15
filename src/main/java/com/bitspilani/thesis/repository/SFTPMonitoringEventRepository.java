package com.bitspilani.thesis.repository;

import com.bitspilani.thesis.model.DBMonitoringEvent;
import com.bitspilani.thesis.model.SFTPMonitoringEvent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SFTPMonitoringEventRepository extends MongoRepository<SFTPMonitoringEvent,String > {
}
