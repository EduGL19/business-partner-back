package com.code.BusinessPartner.domain.impl;

import com.code.BusinessPartner.domain.aggregates.dto.SaleDto;
import com.code.BusinessPartner.domain.aggregates.request.SaleRequest;
import com.code.BusinessPartner.domain.ports.in.SaleServiceIn;
import com.code.BusinessPartner.domain.ports.out.SaleServiceOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SaleServiceImpl implements SaleServiceIn {

    private  final SaleServiceOut saleServiceOut;

    @Override
    public SaleDto createIn(SaleRequest saleRequest) {
        return saleServiceOut.createOut(saleRequest);
    }

    @Override
    public List<SaleDto> listIn(String code) {
        return saleServiceOut.listOut(code);
    }

}
