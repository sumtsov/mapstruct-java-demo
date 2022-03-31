package com.dsumtsov.mapstruct.java.demo.mapper;

import com.dsumtsov.mapstruct.java.demo.domain.ShippingFee;
import com.dsumtsov.mapstruct.java.demo.dto.ShippingFeeDTO;
import com.dsumtsov.mapstruct.java.demo.enums.ShippingFeeType;
import com.dsumtsov.mapstruct.java.demo.mapper.util.MappingUtils;
import com.dsumtsov.mapstruct.java.demo.mapper.util.MappingUtils.FeaturesStringToMap;
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
