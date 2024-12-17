package org.redsf.product.use.cases.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.redsf.product.use.cases.models.PriceMO;
import org.redsf.product.domain.PriceDTO;

@Mapper()
public interface PriceMapper {

    @Mapping(source = "curr", target = "curr", defaultValue = "EUR")
    PriceDTO toDto(PriceMO priceMO);
    @Mapping(source = "curr", target = "curr", defaultValue = "EUR")
    PriceMO toModel(PriceDTO priceDTO);
}
