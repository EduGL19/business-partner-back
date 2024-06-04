package com.code.BusinessPartner.domain.ports.out;

import com.code.BusinessPartner.domain.aggregates.dto.CodeDto;
import com.code.BusinessPartner.domain.aggregates.request.CodeRequest;

import java.util.List;
import java.util.Optional;

public interface CodeServiceOut {

    CodeDto createOut(CodeRequest codeRequest);

    Optional<CodeDto> getOut(Long id);

    List<CodeDto> listOut();

    CodeDto updateOut(Long id,CodeRequest codeRequest);

    CodeDto deleteOut(Long id);

}
