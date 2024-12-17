package org.redsf.product.use.cases.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.redsf.product.use.cases.interfaces.out.RepositoryPort;
import org.redsf.product.use.cases.mappers.PriceMapper;
import org.redsf.product.use.cases.models.PriceMO;
import org.redsf.product.domain.PriceDTO;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PriceServiceImplTests {

    @Mock
    private RepositoryPort repositoryPort;

    @Mock
    private PriceMapper priceMapper;

    @InjectMocks
    private PriceServiceImpl priceService;

    @Test
    void testGetPrice_Success() throws NoSuchFieldException {
        // Given
        String publishDate = "2020-06-14-00.00.00";
        String productId = "35455";
        String brandId = "1";

        PriceMO mockPriceMO = new PriceMO();
        PriceDTO expectedPriceDTO = new PriceDTO();

        when(repositoryPort.findBy(35455, 1, publishDate)).thenReturn(mockPriceMO);
        when(priceMapper.toDto(mockPriceMO)).thenReturn(expectedPriceDTO);

        // When
        PriceDTO result = priceService.getPrice(publishDate, productId, brandId);

        // Then
        assertNotNull(result);
        assertEquals(expectedPriceDTO, result);
        verify(repositoryPort, times(1)).findBy(35455, 1, publishDate);
        verify(priceMapper, times(1)).toDto(mockPriceMO);
    }

    @Test
    void testGetPrice_NoSuchElementException() throws NoSuchFieldException {
        // Given
        String publishDate = "2020-06-14-00.00.00";
        String productId = "35455";
        String brandId = "1";

        when(repositoryPort.findBy(35455, 1, publishDate)).thenThrow(NoSuchFieldException.class);

        // When & Then
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () ->
                priceService.getPrice(publishDate, productId, brandId));

        assertEquals("Price element couldn't be found for the given parameters", exception.getMessage());
        verify(repositoryPort, times(1)).findBy(35455, 1, publishDate);
        verifyNoInteractions(priceMapper);
    }

    @Test
    void testGetPrice_InvalidProductId_ThrowsNumberFormatException() {
        // Given
        String publishDate = "2020-06-14-00.00.00";
        String invalidProductId = "invalid";
        String brandId = "1";

        // When & Then
        assertThrows(NumberFormatException.class, () ->
                priceService.getPrice(publishDate, invalidProductId, brandId));

        verifyNoInteractions(repositoryPort);
        verifyNoInteractions(priceMapper);
    }

    @Test
    void testGetPrice_MapperCalledOnce() throws NoSuchFieldException {
        // Given
        String publishDate = "2020-06-14-00.00.00";
        String productId = "35455";
        String brandId = "1";

        PriceMO mockPriceMO = new PriceMO();
        PriceDTO expectedPriceDTO = new PriceDTO();

        when(repositoryPort.findBy(35455, 1, publishDate)).thenReturn(mockPriceMO);
        when(priceMapper.toDto(mockPriceMO)).thenReturn(expectedPriceDTO);

        // When
        priceService.getPrice(publishDate, productId, brandId);

        // Then
        verify(priceMapper, times(1)).toDto(mockPriceMO);
    }
}
