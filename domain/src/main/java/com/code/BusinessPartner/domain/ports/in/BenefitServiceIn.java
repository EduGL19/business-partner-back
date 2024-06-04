package com.code.BusinessPartner.domain.ports.in;

import com.code.BusinessPartner.domain.aggregates.dto.BenefitDto;
import com.code.BusinessPartner.domain.aggregates.request.BenefitRequest;

import java.util.List;
import java.util.Optional;

public interface BenefitServiceIn {

    BenefitDto createIn(BenefitRequest benefitRequest);

    Optional<BenefitDto> getIn(Long id);

    List<BenefitDto> listIn();

    BenefitDto updateIn(Long id,BenefitRequest benefitRequest);

    BenefitDto deleteIn(Long id);

}
