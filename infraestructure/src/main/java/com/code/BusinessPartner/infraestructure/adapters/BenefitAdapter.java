package com.code.BusinessPartner.infraestructure.adapters;

import com.code.BusinessPartner.domain.aggregates.constants.Constant;
import com.code.BusinessPartner.domain.aggregates.dto.BenefitDto;
import com.code.BusinessPartner.domain.aggregates.request.BenefitRequest;
import com.code.BusinessPartner.domain.ports.out.BenefitServiceOut;
import com.code.BusinessPartner.infraestructure.dao.BenefitRepository;
import com.code.BusinessPartner.infraestructure.entity.BenefitEntity;
import com.code.BusinessPartner.infraestructure.mapper.BenefitMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BenefitAdapter implements BenefitServiceOut {

    private final BenefitRepository benefitRepository;

    @Override
    public BenefitDto createOut(BenefitRequest benefitRequest) {
        BenefitEntity benefitEntity = getEntity(benefitRequest,0);
        return  BenefitMapper.fromEntity(benefitRepository.save(benefitEntity));
    }

    @Override
    public Optional<BenefitDto> getOut(Long id) {

        BenefitDto benefitDto = BenefitMapper.fromEntity(benefitRepository.findById(id).get());
        return Optional.of(benefitDto);

    }

    @Override
    public List<BenefitDto> listOut() {
        List<BenefitDto> dtoList = new ArrayList<>();

        List<BenefitEntity> entityList = benefitRepository.findAll();
        for (BenefitEntity dato : entityList) {
            dtoList.add(BenefitMapper.fromEntity(dato));
        }
        return dtoList;
    }

    @Override
    public BenefitDto updateOut(Long id, BenefitRequest benefitRequest) {
        Optional<BenefitEntity> benefitEntity = benefitRepository.findById(id);
        if(benefitEntity.isPresent()){
            BenefitEntity benefit = getEntity(benefitRequest, id);
            benefit.setCreatedby(benefitEntity.get().getCreatedby());
            benefit.setCreatedAt(benefitEntity.get().getCreatedAt());
            return  BenefitMapper.fromEntity(benefitRepository.save(benefit));
        }else {
            throw new RuntimeException();
        }
    }

    @Override
    public BenefitDto deleteOut(Long id) {
        Optional<BenefitEntity> datoExtraido = benefitRepository.findById(id);

        if(datoExtraido.isPresent()){
            datoExtraido.get().setIsActive(false);
            datoExtraido.get().setRejectBy(Constant.USU_ADMIN);
            datoExtraido.get().setRejectAt(getTimestamp());
            return BenefitMapper.fromEntity(benefitRepository.save(datoExtraido.get()));
        }else{
            throw new RuntimeException();
        }
    }



    private BenefitEntity getEntity(BenefitRequest benefitRequest, long id){
        //SunatDto sunatDto = getExcecuteSunat(empresaRequest.getNumDoc());
        BenefitEntity benefitEntity = new BenefitEntity();

        benefitEntity.setName(benefitRequest.getName());
        benefitEntity.setIsActive(Constant.STATUS_ACTIVE);

        if(id == 0){
            benefitEntity.setCreatedby(Constant.USU_ADMIN);
            benefitEntity.setCreatedAt(getTimestamp());
        }else {
            benefitEntity.setIdBenefit(id);
            benefitEntity.setUpdatedBy(Constant.USU_ADMIN);
            benefitEntity.setUpdatedAt(getTimestamp());
        }

        return benefitEntity;
    }

    private Timestamp getTimestamp() {
        long currenTime = System.currentTimeMillis();
        return new Timestamp(currenTime);
    }



}
