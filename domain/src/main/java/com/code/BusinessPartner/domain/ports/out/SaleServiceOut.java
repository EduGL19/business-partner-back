package com.code.BusinessPartner.domain.ports.out;

import com.code.BusinessPartner.domain.aggregates.dto.SaleDto;
import com.code.BusinessPartner.domain.aggregates.request.SaleRequest;

import java.util.List;

public interface SaleServiceOut {
    SaleDto createOut(SaleRequest saleRequest);

    List<SaleDto> listOut(String code);
}
