package org.redsf.product.database.repository.controllers;

import lombok.AllArgsConstructor;
import org.redsf.product.use.cases.interfaces.out.RepositoryPort;
import org.redsf.product.use.cases.models.PriceMO;
import org.redsf.product.database.repository.PriceJpaRepository;
import org.redsf.product.database.repository.mappers.JpaEntityMapper;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class RepositoryPortImpl implements RepositoryPort {

    private final PriceJpaRepository priceJpaRepository;
    private final JpaEntityMapper priceMapper;

    @Override
    public PriceMO findBy(int productId, int brandId, String startDate) throws NoSuchFieldException {
        var result = priceJpaRepository
                .findByProductIdAndBrandIdAndDate(productId, brandId, startDate)
                .stream()
                .findFirst();

        if (result.isEmpty()) {
            throw new NoSuchFieldException("Price couldn't be found");
        }

        return priceMapper.toModel(result.get());
    }
}