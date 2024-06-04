package com.code.BusinessPartner.application.controller;

import com.code.BusinessPartner.domain.aggregates.dto.CodeDto;
import com.code.BusinessPartner.domain.aggregates.dto.ResourceDto;
import com.code.BusinessPartner.domain.aggregates.request.CodeRequest;
import com.code.BusinessPartner.domain.aggregates.request.ResourceRequest;
import com.code.BusinessPartner.domain.ports.in.CodeServiceIn;
import com.code.BusinessPartner.domain.ports.in.ResourceServiceIn;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/BusinessPartner/v1/code")
@AllArgsConstructor
public class CodeController {

    private final CodeServiceIn codeServiceIn;

    @PostMapping
    public ResponseEntity<CodeDto> create(@RequestBody CodeRequest codeRequest){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(codeServiceIn.createIn(codeRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CodeDto> get(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(codeServiceIn.getIn(id).get());
    }

    @GetMapping("/list")
    public ResponseEntity<List<CodeDto>> list(){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(codeServiceIn.listIn());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CodeDto> update(@PathVariable Long id,@RequestBody CodeRequest codeRequest){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(codeServiceIn.updateIn(id,codeRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CodeDto> delete(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(codeServiceIn.deleteIn(id));
    }


}
