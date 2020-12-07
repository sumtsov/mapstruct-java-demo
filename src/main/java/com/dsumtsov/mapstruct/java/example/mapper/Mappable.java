package com.dsumtsov.mapstruct.java.example.mapper;

public interface Mappable<D, E> {
    D toDto(E entity);
}
