package com.bitspilani.thesis.repository;

import com.bitspilani.thesis.model.SFTPStorageEvent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SFTPStorageEventRepository extends MongoRepository<SFTPStorageEvent,String > {
}
