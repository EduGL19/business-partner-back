package com.code.BusinessPartner.application.controller;


import com.code.BusinessPartner.domain.aggregates.dto.ProductDto;
import com.code.BusinessPartner.domain.aggregates.dto.ResourceDto;
import com.code.BusinessPartner.domain.aggregates.request.ProductRequest;
import com.code.BusinessPartner.domain.ports.in.ProductServiceIn;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/BusinessPartner/v1/product")
@AllArgsConstructor
public class ProductController {

    private final ProductServiceIn productServiceIn;

    @PostMapping
    public ResponseEntity<ProductDto> create(@RequestBody ProductRequest productRequest){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productServiceIn.createIn(productRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> get(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productServiceIn.getIn(id).get());
    }

    @GetMapping("/list")
    public ResponseEntity<List<ProductDto>> list(){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productServiceIn.listIn());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> update(@PathVariable Long id,@RequestBody ProductRequest productRequest){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productServiceIn.updateIn(id,productRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductDto> delete(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productServiceIn.deleteIn(id));
    }

    @PostMapping("/upload")
    public ResponseEntity<ProductDto> upload(@RequestParam("file") MultipartFile multipartFile){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productServiceIn.uploadIn(multipartFile));
    }

}
