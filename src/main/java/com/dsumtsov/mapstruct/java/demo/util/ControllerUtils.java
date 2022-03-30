package com.dsumtsov.mapstruct.java.demo.util;

import com.dsumtsov.mapstruct.java.demo.mapper.Mappable;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.NonNull;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;

import java.util.List;
import java.util.Map;

public class ControllerUtils {

    private ControllerUtils() {}

    public static <D, E> D convertEntityToDto(E model,
                                               @NonNull Mappable<D, E> mapper) {
        return model != null ? mapper.toDto(model) : null;
    }

    public static <D, E> List<D> convertListToDtoList(List<E> list,
                                                       @NonNull Mappable<D, E> mapper) {
        List<D> dtoList = Lists.newArrayList();
        if (CollectionUtils.isNotEmpty(list)) {
            list.forEach(model -> {
                D dto = mapper.toDto(model);
                dtoList.add(dto);
            });
        }
        return dtoList;
    }

    public static <D, E, K> Map<K, D> convertMapToDtoMap(Map<K, E> map,
                                                         @NonNull Mappable<D, E> mapper) {
        Map<K, D> dtoMap = Maps.newHashMap();
        if (MapUtils.isNotEmpty(map)) {
            map.forEach((key, oldValue) -> {
                D value = convertEntityToDto(oldValue, mapper);
                dtoMap.put(key, value);
            });
        }
        return dtoMap;
    }
}
