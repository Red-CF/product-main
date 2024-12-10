package org.redsf.product.application.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.redsf.product.application.models.PriceMO;
import org.redsf.product.domain.PriceDTO;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    @Mapping(source = "curr", target = "curr", defaultValue = "EUR")
    PriceDTO toDto(PriceMO priceMO);
    @Mapping(source = "curr", target = "curr", defaultValue = "EUR")
    PriceMO toMo(PriceDTO priceDTO);
}
