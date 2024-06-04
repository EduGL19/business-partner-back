package com.code.BusinessPartner.application.controller;

import com.code.BusinessPartner.domain.aggregates.dto.BenefitDto;
import com.code.BusinessPartner.domain.aggregates.request.BenefitRequest;
import com.code.BusinessPartner.domain.ports.in.BenefitServiceIn;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/BusinessPartner/v1/benefit")
@AllArgsConstructor
public class BenefitController {

    private final BenefitServiceIn benefitServiceIn;

    @PostMapping
    public ResponseEntity<BenefitDto> create(@RequestBody BenefitRequest benefitRequest){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(benefitServiceIn.createIn(benefitRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BenefitDto> get(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(benefitServiceIn.getIn(id).get());
    }

    @GetMapping("/list")
    public ResponseEntity<List<BenefitDto>> list(){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(benefitServiceIn.listIn());
    }

    @PutMapping("/{id}")
    public ResponseEntity<BenefitDto> update(@PathVariable Long id,@RequestBody BenefitRequest benefitRequest){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(benefitServiceIn.updateIn(id,benefitRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BenefitDto> delete(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(benefitServiceIn.deleteIn(id));
    }


}
