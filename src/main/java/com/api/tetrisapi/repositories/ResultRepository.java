package com.api.tetrisapi.repositories;

import com.api.tetrisapi.models.ResultModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ResultRepository extends JpaRepository<ResultModel, UUID> {
}
