package com.serge.reminder.integration.service;

import com.serge.reminder.dto.RemindCreateEditDto;
import com.serge.reminder.dto.RemindReadDto;
import com.serge.reminder.entity.Remind;
import com.serge.reminder.integration.IntegrationTestBase;
import com.serge.reminder.service.RemindService;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.hibernate.grammars.hql.HqlParser;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@RequiredArgsConstructor
class RemindServiceIT extends IntegrationTestBase {
    private final LocalDateTime TEST_DATE_TIME = LocalDateTime.of(2025, 6, 6, 15, 16);
    private final RemindService remindService;

    @Test
    void findAll() {
        List<RemindReadDto> all = remindService.findAll();

        assertThat(all).hasSize(5);
    }

    @Test
    void findById() {
        Optional<RemindReadDto> actualRemind = remindService.findById(1L);

        assertThat(actualRemind).isPresent();
    }

    @Test
    void create() {
        RemindCreateEditDto createEditDto = new RemindCreateEditDto("title", "description", TEST_DATE_TIME);

        RemindReadDto readDto = remindService.create(createEditDto);
        assertThat(readDto.getTitle()).isEqualTo(createEditDto.getTitle());
        assertThat(readDto.getDescription()).isEqualTo(createEditDto.getDescription());
        assertThat(readDto.getRemind()).isEqualTo(createEditDto.getRemind());
    }

    @Test
    void update() {
        RemindCreateEditDto dto = new RemindCreateEditDto("title", "description", TEST_DATE_TIME);

        Optional<RemindReadDto> updatedRemind = remindService.update(1L, dto);

        assertThat(updatedRemind).isPresent();
        updatedRemind.ifPresent(updated -> {
            assertEquals(dto.getTitle(), updated.getTitle());
            assertEquals(dto.getDescription(), updated.getDescription());
            assertEquals(dto.getRemind(), updated.getRemind());
        });
    }

    @Test
    void delete() {
assertFalse(remindService.delete(-1L));
assertTrue(remindService.delete(1L));
    }
}