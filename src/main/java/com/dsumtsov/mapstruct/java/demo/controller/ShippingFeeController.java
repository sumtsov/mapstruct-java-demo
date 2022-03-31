package com.dsumtsov.mapstruct.java.demo.controller;

import com.dsumtsov.mapstruct.java.demo.mapper.ShippingFeeMapper;
import com.dsumtsov.mapstruct.java.demo.domain.ShippingFee;
import com.dsumtsov.mapstruct.java.demo.service.ShippingFeeService;
import com.dsumtsov.mapstruct.java.demo.util.ControllerUtils;
import com.dsumtsov.mapstruct.java.demo.dto.ShippingFeeDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Tag(name = "api/v1/shipping-fee")
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
