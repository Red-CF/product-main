package org.redsf.product.apirest.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.redsf.product.use.cases.interfaces.in.PriceService;
import org.redsf.product.use.cases.mappers.PriceMapper;
import org.redsf.product.domain.PriceDTO;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PricesControllerTests {

    @Mock
    private PriceMapper priceMapper;
    @Mock
    private PriceService priceService;

    @InjectMocks
    private PricesController pricesController;


    @Test
    void testGetPrices() {
        //Given
        when(priceService.getPrice("2020-06-14-00.00.00", "35455", "1")).thenReturn(new PriceDTO());
        //When
        var result = pricesController.getPrice("2020-06-14-00.00.00", "35455", "1");
        //Then
        assertNotNull(result);
        verify(priceMapper,times(1)).toModel(any());
        verify(priceService,times(1)).getPrice("2020-06-14-00.00.00", "35455", "1");
    }

    @Test
    void testGetEmptyPrices() {
        //Given
        //When
        var result = pricesController.getPrice("2020-06-14-00.00.00", "35455", "1");
        //Then
        assertThat("", result.getStatusCode().is4xxClientError(), equalTo(true));
    }

}
