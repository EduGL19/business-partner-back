package com.code.BusinessPartner.domain.impl;

import com.code.BusinessPartner.domain.aggregates.dto.BenefitDto;
import com.code.BusinessPartner.domain.aggregates.request.BenefitRequest;
import com.code.BusinessPartner.domain.ports.in.BenefitServiceIn;
import com.code.BusinessPartner.domain.ports.out.BenefitServiceOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BenefitServiceImpl  implements BenefitServiceIn {

    private  final BenefitServiceOut benefitServiceOut;
    @Override
    public BenefitDto createIn(BenefitRequest benefitRequest) {
        return benefitServiceOut.createOut(benefitRequest);
    }

    @Override
    public Optional<BenefitDto> getIn(Long id) {
        return benefitServiceOut.getOut(id);
    }

    @Override
    public List<BenefitDto> listIn() {
        return benefitServiceOut.listOut();
    }

    @Override
    public BenefitDto updateIn(Long id, BenefitRequest benefitRequest) {
        return benefitServiceOut.updateOut(id,benefitRequest);
    }

    @Override
    public BenefitDto deleteIn(Long id) {
        return benefitServiceOut.deleteOut(id);
    }

}
