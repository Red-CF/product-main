package org.redsf.product.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceDTO {
    private double price;
    private int priceList;
    private String productId;
    private int priority;
    private CurrencyTypes curr;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
