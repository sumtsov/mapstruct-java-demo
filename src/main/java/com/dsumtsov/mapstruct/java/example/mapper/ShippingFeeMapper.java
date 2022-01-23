package com.dsumtsov.mapstruct.java.example.mapper;

import com.dsumtsov.mapstruct.java.example.model.ShippingFee;
import com.dsumtsov.mapstruct.java.example.dto.ShippingFeeDTO;
import com.dsumtsov.mapstruct.java.example.enums.ShippingFeeType;
import com.dsumtsov.mapstruct.java.example.mapper.util.MappingUtils;
import com.dsumtsov.mapstruct.java.example.mapper.util.MappingUtils.FeaturesStringToMap;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(uses = MappingUtils.class)
public interface ShippingFeeMapper extends Mappable<ShippingFeeDTO, ShippingFee> {

    ShippingFeeMapper MAPPER = Mappers.getMapper(ShippingFeeMapper.class);

    @Mapping(source = "shippingFee.type",
    target = "type",
    qualifiedByName = "shippingFeeTypeToValue")
    @Mapping(source = "shippingFee.features",
    target = "features",
    qualifiedBy = FeaturesStringToMap.class)
    ShippingFeeDTO toDto(ShippingFee shippingFee);

    @Named("shippingFeeTypeToValue")
    static Integer shippingFeeTypeToValue(ShippingFeeType type) {
        return type.getValue();
    }
}
