package com.serge.reminder.mapper;

import org.springframework.stereotype.Component;


public interface Mapper<F,T> {
    T map(F object);

    default T map(F fromObject, T toObject) {
        return toObject;
    }
}
