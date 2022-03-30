package com.dsumtsov.mapstruct.java.demo.dto;

import lombok.Data;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Data
public class ShippingFeeDTO {
    private Long id;
    private Set<String> supportedDestinations = new HashSet<>();
    private Integer type;
    private Integer discount;
    private Map<String, String> features;
}
