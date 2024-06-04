package com.code.BusinessPartner.domain.impl;

import com.code.BusinessPartner.domain.aggregates.dto.ProductDto;
import com.code.BusinessPartner.domain.aggregates.request.ProductRequest;
import com.code.BusinessPartner.domain.ports.in.ProductServiceIn;
import com.code.BusinessPartner.domain.ports.out.BenefitServiceOut;
import com.code.BusinessPartner.domain.ports.out.ProductServiceOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductServiceIn {

    private  final ProductServiceOut productServiceOut;

    @Override
    public ProductDto createIn(ProductRequest productRequest) {
        return productServiceOut.createOut(productRequest);
    }

    @Override
    public Optional<ProductDto> getIn(Long id) {
        return productServiceOut.getOut(id);
    }

    @Override
    public List<ProductDto> listIn() {
        return productServiceOut.listOut();
    }

    @Override
    public ProductDto updateIn(Long id, ProductRequest productRequest) {
        return productServiceOut.updateOut(id,productRequest);
    }

    @Override
    public ProductDto deleteIn(Long id) {
        return productServiceOut.deleteOut(id);
    }

    @Override
    public ProductDto uploadIn(MultipartFile multipartFile) {
        return productServiceOut.uploadOut(multipartFile);
    }

}
