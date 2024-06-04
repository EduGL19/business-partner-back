package com.code.BusinessPartner.domain.ports.in;

import com.code.BusinessPartner.domain.aggregates.dto.ProductDto;
import com.code.BusinessPartner.domain.aggregates.request.ProductRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface ProductServiceIn {
    ProductDto createIn(ProductRequest productRequest);

    Optional<ProductDto> getIn(Long id);

    List<ProductDto> listIn();

    ProductDto updateIn(Long id,ProductRequest productRequest);

    ProductDto deleteIn(Long id);

    ProductDto uploadIn(MultipartFile multipartFile);

}
