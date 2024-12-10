package org.redsf.product.application.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceMO {
    private String price;
    private List<String> priceList;
    private String productId;
    private String priority;
    private String finalPrice;
    private String curr;
    private String startDate;
    private String endDate;

}
