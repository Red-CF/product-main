package org.redsf.product.database.repository.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "PRICE")
public class PriceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;
    @Column(name = "BRAND_ID")
    private int brandId;
    @Column(name = "START_DATE")
    private String startDate;
    @Column(name = "END_DATE")
    private String endDate;
    @Column(name = "PRICE_LIST")
    private int priceList;
    @Column(name = "PRODUCT_ID")
    private int productId;
    @Column(name = "PRIORITY")
    private int priority;
    @Column(name = "price")
    private double price;
    @Column(name = "CURR")
    private String curr;

}
