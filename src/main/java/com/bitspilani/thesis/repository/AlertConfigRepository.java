package com.bitspilani.thesis.repository;

import com.bitspilani.thesis.model.EventConfig;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertConfigRepository extends CrudRepository<EventConfig, Long> {
}
