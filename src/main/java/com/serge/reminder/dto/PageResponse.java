package com.serge.reminder.dto;

import lombok.Value;

import java.util.List;
@Value(staticConstructor = "of")
public class PageResponse<T> {
    int total;
    int current;
    List<T> content;
}
