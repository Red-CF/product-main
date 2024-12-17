package org.redsf.product.database.repository.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.redsf.product.use.cases.models.PriceMO;
import org.redsf.product.database.repository.entities.PriceEntity;

@Mapper()
public interface JpaEntityMapper {
    @Mapping(target = "productId", expression = "java(String.valueOf(price.getProductId()))")
    @Mapping(target = "priority", expression = "java(String.valueOf(price.getPriority()))")
    @Mapping(target = "price", expression = "java(String.valueOf(price.getPrice()))")
    @Mapping(target = "priceList", expression = "java(String.valueOf(price.getPriceList()))")
    @Mapping(target = "curr", expression = "java(String.valueOf(price.getCurr()))")
    @Mapping(target = "startDate", expression = "java(String.valueOf(price.getStartDate()))")
    @Mapping(target = "endDate", expression = "java(String.valueOf(price.getEndDate()))")
    PriceMO toModel(PriceEntity price);

}
