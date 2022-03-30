package com.dsumtsov.mapstruct.java.demo.mapper;

public interface Mappable<D, E> {
    D toDto(E entity);
}
