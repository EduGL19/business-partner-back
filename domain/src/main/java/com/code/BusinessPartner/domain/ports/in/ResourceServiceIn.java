package com.code.BusinessPartner.domain.ports.in;

import com.code.BusinessPartner.domain.aggregates.dto.ResourceDto;
import com.code.BusinessPartner.domain.aggregates.request.ResourceRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface ResourceServiceIn {

    ResourceDto createIn(ResourceRequest resourceRequest);

    Optional<ResourceDto> getIn(Long id);

    List<ResourceDto> listIn();

    ResourceDto updateIn(Long id,ResourceRequest resourceRequest);

    ResourceDto deleteIn(Long id);

    ResourceDto uploadIn(MultipartFile multipartFile);

}
