package com.code.BusinessPartner.domain.ports.out;

import com.code.BusinessPartner.domain.aggregates.dto.ProductDto;
import com.code.BusinessPartner.domain.aggregates.request.ProductRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface ProductServiceOut {

    ProductDto createOut(ProductRequest productRequest);

    Optional<ProductDto> getOut(Long id);

    List<ProductDto> listOut();

    ProductDto updateOut(Long id,ProductRequest productRequest);

    ProductDto deleteOut(Long id);

    ProductDto uploadOut(MultipartFile multipartFile);

}
