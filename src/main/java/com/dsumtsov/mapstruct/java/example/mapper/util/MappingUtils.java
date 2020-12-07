package com.dsumtsov.mapstruct.java.example.mapper.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.mapstruct.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Type;
import java.util.Map;

public class MappingUtils {

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface FeaturesStringToMap {
    }

    @FeaturesStringToMap
    public Map<String, String> featuresStringToMap(String features) {
        Gson gson = new Gson();
        Type mapType = new TypeToken<Map<String, String>>() {}.getType();
        return gson.fromJson(features, mapType);
    }
}
