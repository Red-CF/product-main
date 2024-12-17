package org.redsf.product.use.cases.interfaces.out;

import org.redsf.product.use.cases.models.PriceMO;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPort {
    PriceMO findBy(int productId, int brandId, String startDate)  throws NoSuchFieldException;
}
