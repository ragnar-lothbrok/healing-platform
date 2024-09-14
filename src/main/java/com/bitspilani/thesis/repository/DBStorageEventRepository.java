package com.bitspilani.thesis.repository;

import com.bitspilani.thesis.model.DatabaseStorageEvent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBStorageEventRepository extends MongoRepository<DatabaseStorageEvent,String > {
}
