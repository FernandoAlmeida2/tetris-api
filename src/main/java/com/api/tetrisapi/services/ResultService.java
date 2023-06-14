package com.api.tetrisapi.services;

import com.api.tetrisapi.models.ResultModel;
import com.api.tetrisapi.repositories.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ResultService {

    @Autowired
    ResultRepository resultRepository;

    public ResultModel save(ResultModel resultModel) {
        return resultRepository.save(resultModel);
    }

    public List<ResultModel> findAll() {
        return resultRepository.findAll(Sort.by(Sort.Direction.DESC, "score"));
    }

    public Optional<ResultModel> findById(UUID id) {
        return resultRepository.findById(id);
    }

    public void deleteById(UUID id) {
        resultRepository.deleteById(id);
    }
}
