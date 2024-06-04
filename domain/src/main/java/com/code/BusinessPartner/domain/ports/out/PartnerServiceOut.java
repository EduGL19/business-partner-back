package com.code.BusinessPartner.domain.ports.out;

import com.code.BusinessPartner.domain.aggregates.dto.PartnerDto;
import com.code.BusinessPartner.domain.aggregates.dto.ProductDto;
import com.code.BusinessPartner.domain.aggregates.request.PartnerRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface PartnerServiceOut {

    PartnerDto createOut(PartnerRequest partnerRequest);

    Optional<PartnerDto> getOut(Long id);

    List<PartnerDto> listOut();

    PartnerDto updateOut(Long id,PartnerRequest partnerRequest);

    PartnerDto deleteOut(Long id);

    PartnerDto uploadOut(MultipartFile multipartFile);

    PartnerDto approvedOut(Long id, PartnerRequest partnerRequest);

    PartnerDto rejectedOut(Long id);

}
