package org.redsf.product.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceDTO {
    private int price;
    private List<String> priceList;
    private String productId;
    private int priority;
    private double finalPrice;
    private CurrencyTypes curr;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
