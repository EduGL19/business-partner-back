package com.code.BusinessPartner.infraestructure.adapters;

import com.code.BusinessPartner.domain.aggregates.constants.Constant;
import com.code.BusinessPartner.domain.aggregates.dto.CodeDto;
import com.code.BusinessPartner.domain.aggregates.request.CodeRequest;
import com.code.BusinessPartner.domain.ports.out.CodeServiceOut;
import com.code.BusinessPartner.infraestructure.dao.CodeRepository;
import com.code.BusinessPartner.infraestructure.entity.CodeEntity;
import com.code.BusinessPartner.infraestructure.mapper.CodeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CodeAdapter implements CodeServiceOut {

    private final CodeRepository codeRepository;

    @Override
    public CodeDto createOut(CodeRequest codeRequest) {
        CodeEntity codeEntity = getEntity(codeRequest,0);
        return  CodeMapper.fromEntity(codeRepository.save(codeEntity));
    }

    @Override
    public Optional<CodeDto> getOut(Long id) {
        CodeDto codeDto = CodeMapper.fromEntity(codeRepository.findById(id).get());
        return Optional.of(codeDto);
    }

    @Override
    public List<CodeDto> listOut() {
        List<CodeDto> dtoList = new ArrayList<>();

        List<CodeEntity> entityList = codeRepository.findAll();
        for (CodeEntity dato : entityList) {
            dtoList.add(CodeMapper.fromEntity(dato));
        }

        return dtoList;
    }

    @Override
    public CodeDto updateOut(Long id, CodeRequest codeRequest) {
        Optional<CodeEntity> codeEntity = codeRepository.findById(id);
        if(codeEntity.isPresent()){
            CodeEntity code = getEntity(codeRequest, id);
            code.setCode(codeEntity.get().getCode());
            code.setCreatedby(codeEntity.get().getCreatedby());
            code.setCreatedAt(codeEntity.get().getCreatedAt());
            return  CodeMapper.fromEntity(codeRepository.save(code));
        }else {
            throw new RuntimeException();
        }
    }

    @Override
    public CodeDto deleteOut(Long id) {
        Optional<CodeEntity> datoExtraido = codeRepository.findById(id);

        if(datoExtraido.isPresent()){
            datoExtraido.get().setIsActive(false);
            datoExtraido.get().setRejectBy(Constant.USU_ADMIN);
            datoExtraido.get().setRejectAt(getTimestamp());
            return CodeMapper.fromEntity(codeRepository.save(datoExtraido.get()));
        }else{
            throw new RuntimeException();
        }
    }

    private CodeEntity getEntity(CodeRequest codeRequest, long id){

        CodeEntity codeEntity = new CodeEntity();

        //codeEntity.setCode(codeRequest.getCode());
        codeEntity.setAvailable(codeRequest.getAvailable());
        codeEntity.setIsActive(Constant.STATUS_ACTIVE);

        if(id == 0){
            codeEntity.setCode(codeRequest.getCode());
            codeEntity.setCreatedby(Constant.USU_ADMIN);
            codeEntity.setCreatedAt(getTimestamp());
        }else {
            codeEntity.setIdCode(id);
            codeEntity.setIdPartner(codeRequest.getIdPartner());
            codeEntity.setUpdatedBy(Constant.USU_ADMIN);
            codeEntity.setUpdatedAt(getTimestamp());
        }

        return codeEntity;
    }

    private Timestamp getTimestamp() {
        long currenTime = System.currentTimeMillis();
        return new Timestamp(currenTime);
    }


}
