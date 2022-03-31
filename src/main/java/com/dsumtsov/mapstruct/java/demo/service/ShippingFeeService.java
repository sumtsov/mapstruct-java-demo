package com.dsumtsov.mapstruct.java.demo.service;

import com.dsumtsov.mapstruct.java.demo.domain.ShippingFee;
import com.dsumtsov.mapstruct.java.demo.enums.ShippingFeeType;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class ShippingFeeService {

    public ShippingFee getShippingFee() {
        ShippingFee shippingFee = new ShippingFee();
        shippingFee.setId(1L);
        shippingFee.setSupportedDestinations(Sets.newHashSet("destination_1", "destination_2"));
        shippingFee.setType(ShippingFeeType.STANDARD);
        shippingFee.setDiscount(10);
        shippingFee.setFeatures("{'feature_1':'1', 'feature_2':'2'}");

        return shippingFee;
    }

    public List<ShippingFee> getShippingFeeList() {
        return Arrays.asList(getShippingFee());
    }

    public Map<Long, ShippingFee> getShippingFeeMap() {
        return ImmutableMap.of(1L, getShippingFee());
    }
}
