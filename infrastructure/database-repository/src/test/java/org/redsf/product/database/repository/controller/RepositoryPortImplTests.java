package org.redsf.product.database.repository.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.redsf.product.use.cases.models.PriceMO;
import org.redsf.product.database.repository.PriceJpaRepository;
import org.redsf.product.database.repository.controllers.RepositoryPortImpl;
import org.redsf.product.database.repository.entities.PriceEntity;
import org.redsf.product.database.repository.mappers.JpaEntityMapper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RepositoryPortImplTests {

    @Mock
    private PriceJpaRepository priceJpaRepository;

    @Mock
    private JpaEntityMapper priceMapper;

    @InjectMocks
    private RepositoryPortImpl repositoryPortImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindBy_Success() throws NoSuchFieldException {
        // Given
        int productId = 35455;
        int brandId = 1;
        String startDate = "2020-06-14-00.00.00";

        // Mocked Entity and Model
        PriceEntity priceEntity = new PriceEntity();
        priceEntity.setProductId(productId);
        priceEntity.setBrandId(brandId);
        priceEntity.setStartDate(startDate);

        PriceMO priceMO = new PriceMO();
        priceMO.setProductId("35455");
        priceMO.setStartDate("2020-06-14-00.00.00");

        // Mock repository response
        when(priceJpaRepository.findByProductIdAndBrandIdAndDate(productId, brandId, startDate))
                .thenReturn(List.of(priceEntity));
        when(priceMapper.toModel(priceEntity)).thenReturn(priceMO);

        // When
        PriceMO result = repositoryPortImpl.findBy(productId, brandId, startDate);

        // Then
        assertNotNull(result);
        assertEquals("35455", result.getProductId());
        assertEquals("2020-06-14-00.00.00", result.getStartDate());

        verify(priceJpaRepository, times(1)).findByProductIdAndBrandIdAndDate(productId, brandId, startDate);
        verify(priceMapper, times(1)).toModel(priceEntity);
    }

    @Test
    void testFindBy_NotFound() {
        // Given
        int productId = 35455;
        int brandId = 1;
        String startDate = "2020-06-14-00.00.00";

        // Mock repository returns empty list
        when(priceJpaRepository.findByProductIdAndBrandIdAndDate(productId, brandId, startDate))
                .thenReturn(List.of());

        // When / Then
        Exception exception = assertThrows(NoSuchFieldException.class, () -> {
            repositoryPortImpl.findBy(productId, brandId, startDate);
        });

        assertEquals("Price couldn't be found", exception.getMessage());

        verify(priceJpaRepository, times(1)).findByProductIdAndBrandIdAndDate(productId, brandId, startDate);
        verifyNoInteractions(priceMapper);
    }
}
