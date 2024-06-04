package com.code.BusinessPartner.application.controller;

import com.code.BusinessPartner.domain.aggregates.dto.SaleDto;
import com.code.BusinessPartner.domain.aggregates.request.SaleRequest;
import com.code.BusinessPartner.domain.ports.in.SaleServiceIn;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/BusinessPartner/v1/sale")
@AllArgsConstructor
public class SaleController {

    private final SaleServiceIn saleServiceIn;

    @PostMapping
    public ResponseEntity<SaleDto> create(@RequestBody SaleRequest saleRequest){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(saleServiceIn.createIn(saleRequest));
    }

    @GetMapping("/{code}")
    public ResponseEntity<List<SaleDto>> list(@PathVariable String code){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(saleServiceIn.listIn(code));
    }

}
