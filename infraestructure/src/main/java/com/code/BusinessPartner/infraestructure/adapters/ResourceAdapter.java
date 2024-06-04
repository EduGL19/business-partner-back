package com.code.BusinessPartner.infraestructure.adapters;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.code.BusinessPartner.domain.aggregates.constants.Constant;
import com.code.BusinessPartner.domain.aggregates.dto.BenefitDto;
import com.code.BusinessPartner.domain.aggregates.dto.ResourceDto;
import com.code.BusinessPartner.domain.aggregates.request.ResourceRequest;
import com.code.BusinessPartner.domain.ports.out.ResourceServiceOut;
import com.code.BusinessPartner.infraestructure.aws.S3Service;
import com.code.BusinessPartner.infraestructure.dao.ResourceRepository;
import com.code.BusinessPartner.infraestructure.entity.ResourceEntity;
import com.code.BusinessPartner.infraestructure.mapper.BenefitMapper;
import com.code.BusinessPartner.infraestructure.mapper.ResourceMapper;
import com.code.BusinessPartner.infraestructure.redis.RedisService;
import com.code.BusinessPartner.infraestructure.util.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResourceAdapter implements ResourceServiceOut {

    private final ResourceRepository resourceRepository;
    private final S3Service s3Service;
    private final RedisService redisService;

    @Override
    public ResourceDto createOut(ResourceRequest resourceRequest) {
        ResourceEntity resourceEntity = getEntity(resourceRequest,0);
        return  ResourceMapper.fromEntity(resourceRepository.save(resourceEntity));
    }

    @Override
    public Optional<ResourceDto> getOut(Long id) {

        String redisInfo = redisService.getFromRedis(Constant.REDIS_KEY_GET_RESOURCES);
        if(redisInfo != null){
            ResourceDto resourceDto = Util.convertirDesdeString(redisInfo,ResourceDto.class);
            return Optional.of(resourceDto);
        }else {
            ResourceDto resourceDto = ResourceMapper.fromEntity(resourceRepository.findById(id).get());
            String dataForReadis  = Util.convertirAStringResource(resourceDto);
            redisService.saveInRedis(Constant.REDIS_KEY_GET_RESOURCES+id,dataForReadis,5);
            return Optional.of(resourceDto);
        }

        /*
        ResourceDto resourceDto = ResourceMapper.fromEntity(resourceRepository.findById(id).get());
        return Optional.of(resourceDto);
        */

    }

    @Override
    public List<ResourceDto> listOut() {
        List<ResourceDto> dtoList = new ArrayList<>();

        List<ResourceEntity> entityList = resourceRepository.findAll();
        for (ResourceEntity dato : entityList) {
            dtoList.add(ResourceMapper.fromEntity(dato));
        }

        return dtoList;
    }

    @Override
    public ResourceDto updateOut(Long id, ResourceRequest resourceRequest) {
        Optional<ResourceEntity> resourceEntity = resourceRepository.findById(id);
        if(resourceEntity.isPresent()){
            ResourceEntity resource = getEntity(resourceRequest, id);
            resource.setCreatedby(resourceEntity.get().getCreatedby());
            resource.setCreatedAt(resourceEntity.get().getCreatedAt());
            return  ResourceMapper.fromEntity(resourceRepository.save(resource));
        }else {
            throw new RuntimeException();
        }
    }

    @Override
    public ResourceDto deleteOut(Long id) {
        Optional<ResourceEntity> datoExtraido = resourceRepository.findById(id);

        if(datoExtraido.isPresent()){
            datoExtraido.get().setIsActive(false);
            datoExtraido.get().setRejectBy(Constant.USU_ADMIN);
            datoExtraido.get().setRejectAt(getTimestamp());
            return ResourceMapper.fromEntity(resourceRepository.save(datoExtraido.get()));
        }else{
            throw new RuntimeException();
        }
    }

    public ResourceDto uploadOut(MultipartFile multipartFile) {
        PutObjectResult putObjectResult = s3Service.upload(multipartFile,"resources/");
        ResourceDto resourceDto = new ResourceDto();
        resourceDto.setUrl(multipartFile.getOriginalFilename());
        return resourceDto;
    }

    private ResourceEntity getEntity(ResourceRequest resourceRequest, long id){

        ResourceEntity resourceEntity = new ResourceEntity();

        resourceEntity.setTitle(resourceRequest.getTitle());
        resourceEntity.setUrl(resourceRequest.getUrl());
        resourceEntity.setType(resourceRequest.getType());
        resourceEntity.setTags(resourceRequest.getTags());
        resourceEntity.setIsActive(Constant.STATUS_ACTIVE);

        if(id == 0){
            resourceEntity.setCreatedby(Constant.USU_ADMIN);
            resourceEntity.setCreatedAt(getTimestamp());
        }else {
            resourceEntity.setIdResource(id);
            resourceEntity.setUpdatedBy(Constant.USU_ADMIN);
            resourceEntity.setUpdatedAt(getTimestamp());
        }

        return resourceEntity;
    }

    private Timestamp getTimestamp() {
        long currenTime = System.currentTimeMillis();
        return new Timestamp(currenTime);
    }



}
