package com.code.BusinessPartner.application.controller;

import com.code.BusinessPartner.domain.aggregates.dto.ProductDto;
import com.code.BusinessPartner.domain.aggregates.dto.ResourceDto;
import com.code.BusinessPartner.domain.aggregates.request.ProductRequest;
import com.code.BusinessPartner.domain.aggregates.request.ResourceRequest;
import com.code.BusinessPartner.domain.ports.in.ResourceServiceIn;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/BusinessPartner/v1/resource")
@AllArgsConstructor
public class ResourceController {

    private final ResourceServiceIn resourceServiceIn;

    @PostMapping
    public ResponseEntity<ResourceDto> create(@RequestBody ResourceRequest resourceRequest){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(resourceServiceIn.createIn(resourceRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResourceDto> get(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(resourceServiceIn.getIn(id).get());
    }

    @GetMapping("/list")
    public ResponseEntity<List<ResourceDto>> list(){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(resourceServiceIn.listIn());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResourceDto> update(@PathVariable Long id,@RequestBody ResourceRequest resourceRequest){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(resourceServiceIn.updateIn(id,resourceRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResourceDto> delete(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(resourceServiceIn.deleteIn(id));
    }

    @PostMapping("/upload")
    public ResponseEntity<ResourceDto> upload(@RequestParam("file") MultipartFile multipartFile){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(resourceServiceIn.uploadIn(multipartFile));
    }

}
