package com.code.BusinessPartner.domain.ports.in;

import com.code.BusinessPartner.domain.aggregates.dto.PartnerDto;
import com.code.BusinessPartner.domain.aggregates.request.PartnerRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface PartnerServiceIn {

    PartnerDto createIn(PartnerRequest partnerRequest);

    Optional<PartnerDto> getIn(Long id);

    List<PartnerDto> listIn();

    PartnerDto updateIn(Long id,PartnerRequest partnerRequest);

    PartnerDto deleteIn(Long id);

    PartnerDto uploadIn(MultipartFile multipartFile);

    PartnerDto approvedIn(Long id, PartnerRequest partnerRequest);

    PartnerDto rejectedIn(Long id);

}
