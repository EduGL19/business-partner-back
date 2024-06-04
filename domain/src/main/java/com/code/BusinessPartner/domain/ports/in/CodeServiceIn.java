package com.code.BusinessPartner.domain.ports.in;

import com.code.BusinessPartner.domain.aggregates.dto.CodeDto;
import com.code.BusinessPartner.domain.aggregates.request.CodeRequest;

import java.util.List;
import java.util.Optional;

public interface CodeServiceIn {

    CodeDto createIn(CodeRequest codeRequest);

    Optional<CodeDto> getIn(Long id);

    List<CodeDto> listIn();

    CodeDto updateIn(Long id,CodeRequest codeRequest);

    CodeDto deleteIn(Long id);

}
