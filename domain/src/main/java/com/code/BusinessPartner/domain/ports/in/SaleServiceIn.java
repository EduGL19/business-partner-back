package com.code.BusinessPartner.domain.ports.in;

import com.code.BusinessPartner.domain.aggregates.dto.SaleDto;
import com.code.BusinessPartner.domain.aggregates.request.SaleRequest;

import java.util.List;

public interface SaleServiceIn {

    SaleDto createIn(SaleRequest saleRequest);

    List<SaleDto> listIn(String code);

}
