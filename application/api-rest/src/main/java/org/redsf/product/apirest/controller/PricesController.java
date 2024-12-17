package org.redsf.product.apirest.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redsf.product.use.cases.interfaces.in.PriceService;
import org.redsf.product.use.cases.mappers.PriceMapper;
import org.redsf.product.use.cases.models.PriceMO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
@AllArgsConstructor
public class PricesController {

    private PriceService priceService;
    private PriceMapper priceMapper;

    @GetMapping("/get-price")
    public ResponseEntity<Object> getPrice(@RequestParam String publishDate, @RequestParam String productId, @RequestParam String brandId) {
        var priceByCriteria = Optional.ofNullable(priceService.getPrice(publishDate, productId, brandId));

        if (priceByCriteria.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        PriceMO serverResponse = priceMapper.toModel(priceByCriteria.get());

        return ResponseEntity.ok(serverResponse);
    }

}
