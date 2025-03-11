package com.serge.reminder.dto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class PageResponseTest {
    @Test
    void of() {
        List<String> content = List.of("test", "test", "test");
        Pageable pageable = PageRequest.of(0, 1);
        Page<String> page = new PageImpl<>(content, pageable, 1);

        PageResponse<String> expectedPageResponse = new PageResponse<>(page.getTotalPages(), page.getNumber(), page.getContent());

        PageResponse<String> actualPageResponse = PageResponse.of(page);

        Assertions.assertThat(actualPageResponse).isEqualTo(expectedPageResponse);
    }
}
