package org.redsf.product.use.cases.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceMO {
    private String price;
    private String priceList;
    private String productId;
    private String priority;
    private String curr;
    private String startDate;
    private String endDate;

}
