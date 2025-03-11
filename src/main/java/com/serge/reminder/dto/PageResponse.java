package com.serge.reminder.dto;

import lombok.Value;
import org.springframework.data.domain.Page;

import java.util.List;
@Value()
public class PageResponse<T> {
    int total;
    int current;
    List<T> content;

    public static <T> PageResponse<T> of(Page<T> page) {
        return new PageResponse<T>(page.getTotalPages(), page.getNumber(), page.getContent());
    }
}
