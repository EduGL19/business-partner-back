package com.code.BusinessPartner.infraestructure.adapters;

import com.amazonaws.services.s3.model.PutObjectResult;
import com.code.BusinessPartner.domain.aggregates.constants.Constant;
import com.code.BusinessPartner.domain.aggregates.dto.PartnerDto;
import com.code.BusinessPartner.domain.aggregates.request.PartnerRequest;
import com.code.BusinessPartner.domain.ports.out.PartnerServiceOut;
import com.code.BusinessPartner.infraestructure.aws.S3Service;
import com.code.BusinessPartner.infraestructure.dao.PartnerRepository;
import com.code.BusinessPartner.infraestructure.dao.UserRepository;
import com.code.BusinessPartner.infraestructure.entity.PartnerEntity;
import com.code.BusinessPartner.infraestructure.entity.UserEntity;
import com.code.BusinessPartner.infraestructure.mapper.PartnerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PartnerAdapter implements PartnerServiceOut {

    private final PartnerRepository partnerRepository;
    private final UserRepository userRepository;
    private final S3Service s3Service;

    @Override
    public PartnerDto createOut(PartnerRequest partnerRequest) {
        PartnerEntity partnerEntity = getEntity(partnerRequest,0);
        return  PartnerMapper.fromEntity(partnerRepository.save(partnerEntity));
    }

    @Override
    public Optional<PartnerDto> getOut(Long id) {
        PartnerDto partnerDto = PartnerMapper.fromEntity(partnerRepository.findById(id).get());
        return Optional.of(partnerDto);
    }

    @Override
    public List<PartnerDto> listOut() {
        List<PartnerDto> dtoList = new ArrayList<>();

        List<PartnerEntity> entityList = partnerRepository.findAll();
        for (PartnerEntity dato : entityList) {
            dtoList.add(PartnerMapper.fromEntity(dato));
        }

        return dtoList;
    }

    @Override
    public PartnerDto updateOut(Long id, PartnerRequest partnerRequest) {
        Optional<PartnerEntity> partnerEntity = partnerRepository.findById(id);

        if(partnerEntity.isPresent()){
            PartnerEntity partner = getEntity(partnerRequest, id);
            //partner.setCreatedby(partnerEntity.get().getCreatedby());
            partner.setCreatedAt(partnerEntity.get().getCreatedAt());
            return  PartnerMapper.fromEntity(partnerRepository.save(partner));
        }else {
            throw new RuntimeException();
        }

    }

    @Override
    public PartnerDto deleteOut(Long id) {
        Optional<PartnerEntity> datoExtraido = partnerRepository.findById(id);

        if(datoExtraido.isPresent()){
            datoExtraido.get().setIsActive(false);
            datoExtraido.get().setRejectBy(Constant.USU_ADMIN);
            datoExtraido.get().setRejectAt(getTimestamp());
            return PartnerMapper.fromEntity(partnerRepository.save(datoExtraido.get()));
        }else{
            throw new RuntimeException();
        }
    }

    @Override
    public PartnerDto uploadOut(MultipartFile multipartFile) {
        PutObjectResult putObjectResult = s3Service.upload(multipartFile,"partners/");
        PartnerDto partnerDto = new PartnerDto();
        partnerDto.setImage(multipartFile.getOriginalFilename());
        return partnerDto;
    }

    @Override
    public PartnerDto approvedOut(Long id, PartnerRequest partnerRequest) {

        Optional<PartnerEntity> partnerEntity = partnerRepository.findById(id);
        partnerEntity.get().setStatus(Constant.STATUS_PARTNER_APRO);
        partnerEntity.get().setApproveBy(Constant.USU_ADMIN);
        partnerEntity.get().setApproveAt(getTimestamp());
        partnerEntity.get().setCode(partnerRequest.getCode());
        return  PartnerMapper.fromEntity(partnerRepository.save(partnerEntity.get()));

    }

    @Override
    public PartnerDto rejectedOut(Long id) {

        Optional<PartnerEntity> partnerEntity = partnerRepository.findById(id);
        partnerEntity.get().setStatus(Constant.STATUS_PARTNER_RECH);
        partnerEntity.get().setRejectBy(Constant.USU_ADMIN);
        partnerEntity.get().setRejectAt(getTimestamp());
        return  PartnerMapper.fromEntity(partnerRepository.save(partnerEntity.get()));

    }

    private PartnerEntity getEntity(PartnerRequest partnerRequest, long id){

        PartnerEntity partnerEntity = new PartnerEntity();

        partnerEntity.setFirstName(partnerRequest.getFirstName());
        partnerEntity.setLastName(partnerRequest.getLastName());
        partnerEntity.setEmail(partnerRequest.getEmail());
        partnerEntity.setPhone(partnerRequest.getImage());
        partnerEntity.setRuc(partnerRequest.getRuc());
        partnerEntity.setRucFile(partnerRequest.getRucFile());
        partnerEntity.setBank(partnerRequest.getBank());
        partnerEntity.setBankFile(partnerRequest.getBankFile());
        partnerEntity.setBankCertificate(partnerRequest.getBankCertificate());
        partnerEntity.setDniRepresent(partnerRequest.getDniRepresent());
        partnerEntity.setDniFile(partnerRequest.getDniFile());
        partnerEntity.setCountry(partnerRequest.getCountry());
        partnerEntity.setAddress1(partnerRequest.getAddress1());
        partnerEntity.setAddress2(partnerRequest.getAddress2());
        partnerEntity.setFacebook(partnerRequest.getFacebook());
        partnerEntity.setInstagram(partnerRequest.getInstagram());
        partnerEntity.setTiktok(partnerRequest.getTiktok());
        partnerEntity.setWebSite(partnerRequest.getWebSite());
        partnerEntity.setImage(partnerRequest.getImage());
        //partnerEntity.setStatus(partnerRequest.getStatus());
        partnerEntity.setStatus(Constant.STATUS_PARTNER_SOLI);
        partnerEntity.setCode(partnerRequest.getCode());
        partnerEntity.setIsActive(Constant.STATUS_ACTIVE);

        //partnerEntity.getUsers().setIdUser(partnerRequest.getIdUser());
        Optional<UserEntity> userEntity = userRepository.findById(partnerRequest.getIdUser());
        partnerEntity.setUsers(userEntity.get());


        if(id == 0){
            //partnerEntity.setCreatedby(Constant.USU_ADMIN);
            partnerEntity.setCreatedAt(getTimestamp());
        }else {
            partnerEntity.setIdPartner(id);
            partnerEntity.setUpdatedBy(Constant.USU_ADMIN);
            partnerEntity.setUpdatedAt(getTimestamp());
        }

        return partnerEntity;
    }

    private Timestamp getTimestamp() {
        long currenTime = System.currentTimeMillis();
        return new Timestamp(currenTime);
    }


}
