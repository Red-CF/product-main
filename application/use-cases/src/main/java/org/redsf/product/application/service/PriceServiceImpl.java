package org.redsf.product.application.service;

import lombok.AllArgsConstructor;
import org.redsf.product.application.interfaces.PriceService;
import org.redsf.product.domain.PriceDTO;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PriceServiceImpl implements PriceService {

    @Override
    public PriceDTO getPrice(PriceDTO price) {
        return null;
    }
}
