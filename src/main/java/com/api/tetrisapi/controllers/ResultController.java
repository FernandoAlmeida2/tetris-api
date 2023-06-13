package com.api.tetrisapi.controllers;

import com.api.tetrisapi.dtos.ResultRecordDto;
import com.api.tetrisapi.models.ResultModel;
import com.api.tetrisapi.repositories.ResultRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @GetMapping("/results")
    public ResponseEntity<List<ResultModel>> getAllResults() {
        return ResponseEntity.status(HttpStatus.OK).body(resultRepository.findAll(Sort.by(Sort.Direction.DESC, "score")));
    }

    @GetMapping("/results/{id}")
    public ResponseEntity<Object> getOneResult(@PathVariable(value="id") UUID id){
        Optional<ResultModel> result0 = resultRepository.findById(id);
        if(result0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Result not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(result0.get());
    }

    @PutMapping("/results/{id}")
    public ResponseEntity<Object> updateResult(@PathVariable(value="id") UUID id, @RequestBody @Valid ResultRecordDto resultRecordDto){
        Optional<ResultModel> result0 = resultRepository.findById(id);
        if(result0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Result not found");
        }
        var resultModel = result0.get();
        BeanUtils.copyProperties(resultRecordDto, resultModel);
        return ResponseEntity.status(HttpStatus.OK).body(resultRepository.save(resultModel));
    }
}
