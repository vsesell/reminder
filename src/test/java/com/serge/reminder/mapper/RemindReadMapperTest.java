package com.serge.reminder.mapper;

import com.serge.reminder.dto.RemindReadDto;
import com.serge.reminder.entity.Remind;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;

class RemindReadMapperTest {
    RemindReadMapper mapper = Mappers.getMapper(RemindReadMapper.class);
    @Test
    void map() {
        Remind remind = new Remind(1L, "title", "description", LocalDateTime.now());
        RemindReadDto expectedDto =
                new RemindReadDto(remind.getId(), remind.getTitle(), remind.getDescription(), remind.getRemind());

        RemindReadDto actualDto = mapper.map(remind);

        Assertions.assertThat(actualDto).isEqualTo(expectedDto);
    }
}