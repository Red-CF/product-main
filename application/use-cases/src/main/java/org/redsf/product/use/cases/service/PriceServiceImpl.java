package org.redsf.product.use.cases.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redsf.product.use.cases.interfaces.in.PriceService;
import org.redsf.product.use.cases.interfaces.out.RepositoryPort;
import org.redsf.product.use.cases.mappers.PriceMapper;
import org.redsf.product.use.cases.models.PriceMO;
import org.redsf.product.domain.PriceDTO;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Slf4j
@Service
@AllArgsConstructor
public class PriceServiceImpl implements PriceService {

    private RepositoryPort repositoryPort;
    private PriceMapper priceMapper;

    @Override
    public PriceDTO getPrice(String publishDate, String productId, String brandId) {
        PriceMO model;
        try {
            model = repositoryPort.findBy(Integer.parseInt(productId), Integer.parseInt(brandId), publishDate);
        } catch (NoSuchFieldException e){
            log.error(e.getMessage());
            throw new NoSuchElementException("Price element couldn't be found for the given parameters");
        }
        return priceMapper.toDto(model);
    }
}
