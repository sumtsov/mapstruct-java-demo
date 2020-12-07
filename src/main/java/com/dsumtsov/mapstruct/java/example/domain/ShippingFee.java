package com.dsumtsov.mapstruct.java.example.domain;

import com.dsumtsov.mapstruct.java.example.enums.ShippingFeeType;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class ShippingFee {
    private Long id;
    private Set<String> supportedDestinations = new HashSet<>();
    private ShippingFeeType type;
    private Integer discount;
    private String features;
}
