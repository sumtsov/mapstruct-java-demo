package com.dsumtsov.mapstruct.java.example.controller;

import com.dsumtsov.mapstruct.java.example.domain.ShippingFee;
import com.dsumtsov.mapstruct.java.example.dto.ShippingFeeDTO;
import com.dsumtsov.mapstruct.java.example.mapper.ShippingFeeMapper;
import com.dsumtsov.mapstruct.java.example.service.ShippingFeeService;
import com.dsumtsov.mapstruct.java.example.util.ControllerUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/shipping-fee")
public class ShippingFeeController {

    private final ShippingFeeService service;

    @GetMapping("/get-shipping-fee")
    public ShippingFeeDTO getShippingFee() {
        ShippingFee shippingFee = service.getShippingFee();
        return ControllerUtils.convertEntityToDto(shippingFee, ShippingFeeMapper.MAPPER);
    }

    @GetMapping("/get-shipping-fee-list")
    public List<ShippingFeeDTO> getShippingFeeList() {
        List<ShippingFee> list = service.getShippingFeeList();
        return ControllerUtils.convertListToDtoList(list, ShippingFeeMapper.MAPPER);
    }

    @GetMapping("/get-shipping-fee-map")
    public Map<Long, ShippingFeeDTO> getShippingFeeMap() {
        Map<Long, ShippingFee> map = service.getShippingFeeMap();
        return ControllerUtils.convertMapToDtoMap(map, ShippingFeeMapper.MAPPER);
    }
}
