package com.bitspilani.thesis.repository;

import com.bitspilani.thesis.model.EventConfig;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventConfigRepository extends CrudRepository<EventConfig, Long> {
}
