package com.bitspilani.thesis.repository;

import com.bitspilani.thesis.model.DBMonitoringEvent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBMonitoringEventRepository extends MongoRepository<DBMonitoringEvent,String > {
}
