package com.bitspilani.thesis.repository;

import com.bitspilani.thesis.model.Jobs;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends CrudRepository<Jobs, String> {
}
