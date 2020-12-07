package com.dsumtsov.mapstruct.java.example.enums;

public enum ShippingFeeType {
    STANDARD(1),
    CUSTOM(2),
    FREE_SHIPPING(3);

    private Integer value;

    ShippingFeeType(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
