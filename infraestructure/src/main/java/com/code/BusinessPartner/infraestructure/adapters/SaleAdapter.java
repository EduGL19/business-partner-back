package com.code.BusinessPartner.infraestructure.adapters;

import com.code.BusinessPartner.domain.aggregates.constants.Constant;
import com.code.BusinessPartner.domain.aggregates.dto.CodeDto;
import com.code.BusinessPartner.domain.aggregates.dto.FalabellaDto;
import com.code.BusinessPartner.domain.aggregates.dto.SaleDto;
import com.code.BusinessPartner.domain.aggregates.request.CodeRequest;
import com.code.BusinessPartner.domain.aggregates.request.SaleRequest;
import com.code.BusinessPartner.domain.ports.out.SaleServiceOut;
import com.code.BusinessPartner.infraestructure.client.ClientFalabella;
import com.code.BusinessPartner.infraestructure.dao.SaleRepository;
import com.code.BusinessPartner.infraestructure.entity.CodeEntity;
import com.code.BusinessPartner.infraestructure.entity.SaleEntity;
import com.code.BusinessPartner.infraestructure.mapper.CodeMapper;
import com.code.BusinessPartner.infraestructure.mapper.SaleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SaleAdapter implements SaleServiceOut {

    private final SaleRepository saleRepository;
    private final ClientFalabella clientFalabella;

    @Value("${token.falabella}")
    private String tokenFalabella;


    @Override
    public SaleDto createOut(SaleRequest saleRequest) {
        SaleEntity saleEntity = getEntity(saleRequest,0);
        return  SaleMapper.fromEntity(saleRepository.save(saleEntity));
    }

    @Override
    public List<SaleDto> listOut(String code) {
        List<SaleDto> dtoList = new ArrayList<>();

        List<SaleEntity> entityList = saleRepository.findAll();
        for (SaleEntity dato : entityList) {
            if(dato.getCode().equals(code)){
                dtoList.add(SaleMapper.fromEntity(dato));
            }
        }

        return dtoList;
    }

    private SaleEntity getEntity(SaleRequest saleRequest, long id){

        FalabellaDto falabellaDto = getExcecuteFalabella(saleRequest.getNumber());

        SaleEntity saleEntity = new SaleEntity();

        saleEntity.setIdOrder(saleRequest.getIdOrder());
        saleEntity.setOperationDate(saleRequest.getOperationDate());
        //saleEntity.setCustomer(saleRequest.getCustomer());
        saleEntity.setCustomer(falabellaDto.getNombres() + ' ' + falabellaDto.getApellidoPaterno() + ' ' + falabellaDto.getApellidoMaterno());
        saleEntity.setSku(saleRequest.getSku());
        saleEntity.setAmount(saleRequest.getAmount());
        saleEntity.setSubTotal(saleRequest.getSubTotal());
        saleEntity.setDiscount(saleRequest.getDiscount());
        saleEntity.setTotal(saleRequest.getTotal());
        saleEntity.setCode(saleRequest.getCode());
        saleEntity.setPaymentType(saleRequest.getPaymentType());
        saleEntity.setStatus(saleRequest.getStatus());
        saleEntity.setIsActive(Constant.STATUS_ACTIVE);

        if(id == 0){
            saleEntity.setCreatedby(Constant.USU_ADMIN);
            saleEntity.setCreatedAt(getTimestamp());
        }else {
            saleEntity.setIdSale(id);
            //saleEntity.setUpdatedBy(Constant.USU_ADMIN);
            //saleEntity.setUpdatedAt(getTimestamp());
        }

        return saleEntity;
    }

    private Timestamp getTimestamp() {
        long currenTime = System.currentTimeMillis();
        return new Timestamp(currenTime);
    }

    private FalabellaDto getExcecuteFalabella(String code){

        String authorization = "Bearer" + tokenFalabella;
        return clientFalabella.getInfoSales(code,authorization);

    }

}
