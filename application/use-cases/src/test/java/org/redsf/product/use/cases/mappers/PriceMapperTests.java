package org.redsf.product.use.cases.mappers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.redsf.product.use.cases.models.PriceMO;
import org.redsf.product.domain.CurrencyTypes;
import org.redsf.product.domain.PriceDTO;

import static org.junit.jupiter.api.Assertions.*;

class PriceMapperTests {

    private PriceMapper priceMapper;

    @BeforeEach
    void setUp() {
        priceMapper = Mappers.getMapper(PriceMapper.class);
    }

    @Test
    void testToDto_Success() {
        // Given
        PriceMO priceMO = new PriceMO();
        priceMO.setCurr("USD");

        // When
        PriceDTO result = priceMapper.toDto(priceMO);

        // Then
        assertNotNull(result);
        assertEquals("USD", result.getCurr().getCode());
    }

    @Test
    void testToDto_WithDefaultValue() {
        // Given
        PriceMO priceMO = new PriceMO();
        priceMO.setCurr(null);

        // When
        PriceDTO result = priceMapper.toDto(priceMO);

        // Then
        assertNotNull(result);
        assertEquals("EUR", result.getCurr().getCode());
    }

    @Test
    void testToModel_Success() {
        // Given
        PriceDTO priceDTO = new PriceDTO();
        priceDTO.setCurr(CurrencyTypes.YEN);

        // When
        PriceMO result = priceMapper.toModel(priceDTO);

        // Then
        assertNotNull(result);
        assertEquals("YEN", result.getCurr());
    }

    @Test
    void testToModel_WithDefaultValue() {
        // Given
        PriceDTO priceDTO = new PriceDTO();
        priceDTO.setCurr(null);

        // When
        PriceMO result = priceMapper.toModel(priceDTO);

        // Then
        assertNotNull(result);
        assertEquals("EUR", result.getCurr());
    }
}
