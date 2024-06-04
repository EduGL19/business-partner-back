package com.code.BusinessPartner.infraestructure.adapters;

import com.amazonaws.services.s3.model.PutObjectResult;
import com.code.BusinessPartner.domain.aggregates.constants.Constant;
import com.code.BusinessPartner.domain.aggregates.dto.BenefitDto;
import com.code.BusinessPartner.domain.aggregates.dto.ProductDto;
import com.code.BusinessPartner.domain.aggregates.request.BenefitRequest;
import com.code.BusinessPartner.domain.aggregates.request.ProductRequest;
import com.code.BusinessPartner.domain.ports.out.ProductServiceOut;
import com.code.BusinessPartner.infraestructure.aws.S3Service;
import com.code.BusinessPartner.infraestructure.dao.ProductRepository;
import com.code.BusinessPartner.infraestructure.entity.BenefitEntity;
import com.code.BusinessPartner.infraestructure.entity.ProductEntity;
import com.code.BusinessPartner.infraestructure.mapper.BenefitMapper;
import com.code.BusinessPartner.infraestructure.mapper.ProductMapper;
import com.code.BusinessPartner.infraestructure.redis.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductAdapter implements ProductServiceOut {

    private final ProductRepository productRepository;
    private final S3Service s3Service;

    @Override
    public ProductDto createOut(ProductRequest productRequest) {
        ProductEntity productEntity = getEntity(productRequest,0);
        return  ProductMapper.fromEntity(productRepository.save(productEntity));
    }

    @Override
    public Optional<ProductDto> getOut(Long id) {
        ProductDto productDto = ProductMapper.fromEntity(productRepository.findById(id).get());
        return Optional.of(productDto);
    }

    @Override
    public List<ProductDto> listOut() {
        List<ProductDto> dtoList = new ArrayList<>();

        List<ProductEntity> entityList = productRepository.findAll();
        for (ProductEntity dato : entityList) {
            dtoList.add(ProductMapper.fromEntity(dato));
        }
        return dtoList;
    }

    @Override
    public ProductDto updateOut(Long id, ProductRequest productRequest) {
        Optional<ProductEntity> productEntity = productRepository.findById(id);
        if(productEntity.isPresent()){
            ProductEntity product = getEntity(productRequest, id);
            product.setCreatedby(productEntity.get().getCreatedby());
            product.setCreatedAt(productEntity.get().getCreatedAt());
            return  ProductMapper.fromEntity(productRepository.save(product));
        }else {
            throw new RuntimeException();
        }
    }

    @Override
    public ProductDto deleteOut(Long id) {
        Optional<ProductEntity> datoExtraido = productRepository.findById(id);

        if(datoExtraido.isPresent()){
            datoExtraido.get().setIsActive(false);
            datoExtraido.get().setRejectBy(Constant.USU_ADMIN);
            datoExtraido.get().setRejectAt(getTimestamp());
            return ProductMapper.fromEntity(productRepository.save(datoExtraido.get()));
        }else{
            throw new RuntimeException();
        }
    }

    @Override
    public ProductDto uploadOut(MultipartFile multipartFile) {
        PutObjectResult putObjectResult = s3Service.upload(multipartFile,"products/");
        ProductDto productDto = new ProductDto();
        productDto.setImage(multipartFile.getOriginalFilename());
        return productDto;
    }


    private ProductEntity getEntity(ProductRequest productRequest, long id){

        ProductEntity productEntity = new ProductEntity();

        productEntity.setSku(productRequest.getSku());
        productEntity.setName(productRequest.getName());
        productEntity.setDescription(productRequest.getDescription());
        productEntity.setImage(productRequest.getImage());
        productEntity.setUrlPage(productRequest.getUrlPage());
        productEntity.setUrlShop(productRequest.getUrlShop());
        productEntity.setPriceCurrent(productRequest.getPriceCurrent());
        productEntity.setPriceDiscount(productRequest.getPriceDiscount());
        productEntity.setIsActive(Constant.STATUS_ACTIVE);

        if(id == 0){
            productEntity.setCreatedby(Constant.USU_ADMIN);
            productEntity.setCreatedAt(getTimestamp());
        }else {
            productEntity.setIdProduct(id);
            productEntity.setUpdatedBy(Constant.USU_ADMIN);
            productEntity.setUpdatedAt(getTimestamp());
        }

        return productEntity;
    }

    private Timestamp getTimestamp() {
        long currenTime = System.currentTimeMillis();
        return new Timestamp(currenTime);
    }


}
