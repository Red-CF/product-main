package org.redsf.product.use.cases.interfaces.in;

import org.redsf.product.domain.PriceDTO;

public interface PriceService {
    PriceDTO getPrice(String publishDate, String productId, String brandId);

}
