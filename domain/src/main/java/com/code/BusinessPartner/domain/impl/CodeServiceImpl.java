package com.code.BusinessPartner.domain.impl;

import com.code.BusinessPartner.domain.aggregates.dto.CodeDto;
import com.code.BusinessPartner.domain.aggregates.request.CodeRequest;
import com.code.BusinessPartner.domain.ports.in.CodeServiceIn;
import com.code.BusinessPartner.domain.ports.out.CodeServiceOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CodeServiceImpl implements CodeServiceIn {

    private  final CodeServiceOut codeServiceOut;

    @Override
    public CodeDto createIn(CodeRequest codeRequest) {
        return codeServiceOut.createOut(codeRequest);
    }

    @Override
    public Optional<CodeDto> getIn(Long id) {
        return codeServiceOut.getOut(id);
    }

    @Override
    public List<CodeDto> listIn() {
        return codeServiceOut.listOut();
    }

    @Override
    public CodeDto updateIn(Long id, CodeRequest codeRequest) {
        return codeServiceOut.updateOut(id,codeRequest);
    }

    @Override
    public CodeDto deleteIn(Long id) {
        return codeServiceOut.deleteOut(id);
    }
}
