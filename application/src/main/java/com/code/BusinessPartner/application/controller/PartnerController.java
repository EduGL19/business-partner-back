package com.code.BusinessPartner.application.controller;

import com.code.BusinessPartner.domain.aggregates.dto.PartnerDto;
import com.code.BusinessPartner.domain.aggregates.dto.ProductDto;
import com.code.BusinessPartner.domain.aggregates.request.PartnerRequest;
import com.code.BusinessPartner.domain.ports.in.PartnerServiceIn;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/BusinessPartner/v1/partner")
@AllArgsConstructor
public class PartnerController {

    private final PartnerServiceIn partnerServiceIn;

    @PostMapping
    public ResponseEntity<PartnerDto> create(@RequestBody PartnerRequest partnerRequest){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(partnerServiceIn.createIn(partnerRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PartnerDto> get(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(partnerServiceIn.getIn(id).get());
    }

    @GetMapping("/list")
    public ResponseEntity<List<PartnerDto>> list(){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(partnerServiceIn.listIn());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PartnerDto> update(@PathVariable Long id,@RequestBody PartnerRequest partnerRequest){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(partnerServiceIn.updateIn(id,partnerRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PartnerDto> delete(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(partnerServiceIn.deleteIn(id));
    }

    @PostMapping("/upload")
    public ResponseEntity<PartnerDto> upload(@RequestParam("file") MultipartFile multipartFile){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(partnerServiceIn.uploadIn(multipartFile));
    }

    @PutMapping("/approved/{id}")
    public ResponseEntity<PartnerDto> approved(@PathVariable Long id,@RequestBody PartnerRequest partnerRequest){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(partnerServiceIn.approvedIn(id, partnerRequest));
    }

    @PutMapping("/rejected/{id}")
    public ResponseEntity<PartnerDto> rejected(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(partnerServiceIn.rejectedIn(id));
    }

}
