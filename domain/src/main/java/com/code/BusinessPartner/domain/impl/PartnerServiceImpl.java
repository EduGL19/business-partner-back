package com.code.BusinessPartner.domain.impl;

import com.code.BusinessPartner.domain.aggregates.dto.PartnerDto;
import com.code.BusinessPartner.domain.aggregates.dto.ProductDto;
import com.code.BusinessPartner.domain.aggregates.request.PartnerRequest;
import com.code.BusinessPartner.domain.ports.in.PartnerServiceIn;
import com.code.BusinessPartner.domain.ports.out.BenefitServiceOut;
import com.code.BusinessPartner.domain.ports.out.PartnerServiceOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PartnerServiceImpl implements PartnerServiceIn {

    private  final PartnerServiceOut partnerServiceOut;

    @Override
    public PartnerDto createIn(PartnerRequest partnerRequest) {
        return partnerServiceOut.createOut(partnerRequest);
    }

    @Override
    public Optional<PartnerDto> getIn(Long id) {
        return partnerServiceOut.getOut(id);
    }

    @Override
    public List<PartnerDto> listIn() {
        return partnerServiceOut.listOut();
    }

    @Override
    public PartnerDto updateIn(Long id, PartnerRequest partnerRequest) {
        return partnerServiceOut.updateOut(id,partnerRequest);
    }

    @Override
    public PartnerDto deleteIn(Long id) {
        return partnerServiceOut.deleteOut(id);
    }

    @Override
    public PartnerDto uploadIn(MultipartFile multipartFile) {
        return partnerServiceOut.uploadOut(multipartFile);
    }

    @Override
    public PartnerDto approvedIn(Long id, PartnerRequest partnerRequest) {
        return partnerServiceOut.approvedOut(id,partnerRequest);
    }

    @Override
    public PartnerDto rejectedIn(Long id) {
        return partnerServiceOut.rejectedOut(id);
    }
}
