package com.code.BusinessPartner.domain.ports.out;

import com.code.BusinessPartner.domain.aggregates.dto.BenefitDto;
import com.code.BusinessPartner.domain.aggregates.request.BenefitRequest;

import java.util.List;
import java.util.Optional;

public interface BenefitServiceOut {

    BenefitDto createOut(BenefitRequest benefitRequest);

    Optional<BenefitDto> getOut(Long id);

    List<BenefitDto> listOut();

    BenefitDto updateOut(Long id,BenefitRequest benefitRequest);

    BenefitDto deleteOut(Long id);

}
