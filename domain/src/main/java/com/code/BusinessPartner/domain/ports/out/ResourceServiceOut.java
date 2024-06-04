package com.code.BusinessPartner.domain.ports.out;

import com.code.BusinessPartner.domain.aggregates.dto.ResourceDto;
import com.code.BusinessPartner.domain.aggregates.request.ResourceRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface ResourceServiceOut {
    ResourceDto createOut(ResourceRequest resourceRequest);

    Optional<ResourceDto> getOut(Long id);

    List<ResourceDto> listOut();

    ResourceDto updateOut(Long id,ResourceRequest resourceRequest);

    ResourceDto deleteOut(Long id);

    ResourceDto uploadOut(MultipartFile multipartFile);
}
