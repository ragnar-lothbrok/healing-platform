package com.bitspilani.thesis.repository;

import com.bitspilani.thesis.model.HttpHealthEvent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HttpHealthEventRepository extends MongoRepository<HttpHealthEvent,String > {

}
