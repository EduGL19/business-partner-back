package com.code.BusinessPartner.domain.impl;

import com.code.BusinessPartner.domain.aggregates.dto.ResourceDto;
import com.code.BusinessPartner.domain.aggregates.request.ResourceRequest;
import com.code.BusinessPartner.domain.ports.in.ResourceServiceIn;
import com.code.BusinessPartner.domain.ports.out.ResourceServiceOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ResourceServiceImpl implements ResourceServiceIn {

    private final ResourceServiceOut resourceServiceOut;

    @Override
    public ResourceDto createIn(ResourceRequest resourceRequest) {
        return resourceServiceOut.createOut(resourceRequest);
    }

    @Override
    public Optional<ResourceDto> getIn(Long id) {
        return resourceServiceOut.getOut(id);
    }

    @Override
    public List<ResourceDto> listIn() {
        return resourceServiceOut.listOut();
    }

    @Override
    public ResourceDto updateIn(Long id, ResourceRequest resourceRequest) {
        return resourceServiceOut.updateOut(id,resourceRequest);
    }

    @Override
    public ResourceDto deleteIn(Long id) {
        return resourceServiceOut.deleteOut(id);
    }

    @Override
    public ResourceDto uploadIn(MultipartFile multipartFile) {
        return resourceServiceOut.uploadOut(multipartFile);
    }
}
