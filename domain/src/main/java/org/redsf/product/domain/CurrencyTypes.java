package org.redsf.product.domain;

import lombok.Getter;

@Getter
public enum CurrencyTypes {
    EUR("EUR"),
    DOLLAR("DOLLAR"),
    YEN("YEN");

    private final String code;

    CurrencyTypes(String code) {
        this.code = code;
    }
}
