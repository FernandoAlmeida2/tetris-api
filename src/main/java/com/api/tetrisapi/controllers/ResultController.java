package com.api.tetrisapi.controllers;

import com.api.tetrisapi.dtos.ResultRecordDto;
import com.api.tetrisapi.models.ResultModel;
import com.api.tetrisapi.repositories.ResultRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResultController {

    @Autowired
    ResultRepository resultRepository;

    @PostMapping("/results")
    public ResponseEntity<ResultModel> saveResult(@RequestBody @Valid ResultRecordDto resultRecordDto) {
        var resultModel = new ResultModel();
        BeanUtils.copyProperties(resultRecordDto, resultModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(resultRepository.save(resultModel));
    }
}
