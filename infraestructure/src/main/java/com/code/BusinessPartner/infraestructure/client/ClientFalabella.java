package com.code.BusinessPartner.infraestructure.client;

import com.code.BusinessPartner.domain.aggregates.dto.FalabellaDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="client-reniec",url="https://api.apis.net.pe/v2/reniec/")
public interface ClientFalabella {

    /*
    @GetMapping("/sale")
    FalabellaDto getInfoSales(@RequestParam("code") String code,
                              @RequestHeader("Authorization") String authorization);
    */

    @GetMapping("/dni")
    FalabellaDto getInfoSales(@RequestParam("numero") String code,
                              @RequestHeader("Authorization") String authorization);


}
