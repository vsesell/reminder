package com.serge.reminder.mapper;

import com.serge.reminder.dto.RemindCreateEditDto;
import com.serge.reminder.entity.Remind;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RemindCreateEditMsMapperTest {
    private final RemindCreateEditMsMapper mapper = Mappers.getMapper(RemindCreateEditMsMapper.class);

    @Test
    void dtoToEntity() {
        RemindCreateEditDto dto = new RemindCreateEditDto("title", "description", LocalDateTime.now());
        Remind expectedRemind = new Remind(null, dto.getTitle(), dto.getDescription(), dto.getRemind());

        Remind actualRemind = mapper.map(dto);

        assertThat(actualRemind).isEqualTo(expectedRemind);
    }

    @Test
    void updateEntityFromDto() {
        RemindCreateEditDto dto = new RemindCreateEditDto("title", "description", LocalDateTime.now());
        Remind remindToUpdate = new Remind(null, "title to update", "description to update", null);

        Remind actualRemind = mapper.map(dto, remindToUpdate);

        Assertions.assertAll(
                () -> assertThat(actualRemind.getTitle()).isEqualTo(dto.getTitle()),
                () -> assertThat(actualRemind.getDescription()).isEqualTo(dto.getDescription()),
                () -> assertThat(actualRemind.getRemind()).isEqualTo(dto.getRemind())
        );

    }
}