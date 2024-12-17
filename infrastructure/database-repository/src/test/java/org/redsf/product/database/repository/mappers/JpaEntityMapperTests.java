package org.redsf.product.database.repository.mappers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.redsf.product.use.cases.models.PriceMO;
import org.redsf.product.database.repository.entities.PriceEntity;

import static org.junit.jupiter.api.Assertions.*;

class JpaEntityMapperTests {

    private JpaEntityMapper jpaEntityMapper;

    @BeforeEach
    void setUp() {
        jpaEntityMapper = Mappers.getMapper(JpaEntityMapper.class);
    }

    @Test
    void testToModel_Success() {
        // Given
        PriceEntity priceEntity = new PriceEntity();
        priceEntity.setProductId(35455);
        priceEntity.setPriority(1);
        priceEntity.setPrice(35.50);
        priceEntity.setPriceList(2);
        priceEntity.setCurr("EUR");
        priceEntity.setStartDate("2020-06-14-00.00.00");
        priceEntity.setEndDate("2020-12-31-23.59.59");

        // When
        PriceMO result = jpaEntityMapper.toModel(priceEntity);

        // Then
        assertNotNull(result);
        assertEquals("35455", result.getProductId());
        assertEquals("1", result.getPriority());
        assertEquals("35.5", result.getPrice());
        assertEquals("2", result.getPriceList());
        assertEquals("EUR", result.getCurr());
        assertEquals("2020-06-14-00.00.00", result.getStartDate());
        assertEquals("2020-12-31-23.59.59", result.getEndDate());
    }

    @Test
    void testToModel_NullFields() {
        // Given
        PriceEntity priceEntity = new PriceEntity();
        priceEntity.setProductId(0);
        priceEntity.setPriority(0);
        priceEntity.setPrice(0.0);
        priceEntity.setPriceList(0);

        // When
        PriceMO result = jpaEntityMapper.toModel(priceEntity);

        // Then
        assertNotNull(result);
        assertEquals("0", result.getProductId());
        assertEquals("0", result.getPriority());
        assertEquals("0.0", result.getPrice());
        assertEquals("0", result.getPriceList());
    }
}
