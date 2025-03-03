package com.serge.reminder.mapper;

import com.serge.reminder.dto.RemindCreateEditDto;
import com.serge.reminder.entity.Remind;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RemindCreateEditMapperTest {
    private final RemindCreateEditMapper remindCreateEditMapper = new RemindCreateEditMapper();

    @Test
    void map() {
        RemindCreateEditDto dto = new RemindCreateEditDto("title", "description", LocalDateTime.now());
        Remind expectedRemind = new Remind(null, dto.getTitle(), dto.getDescription(), dto.getRemind());

        Remind actualRemind = remindCreateEditMapper.map(dto);

        assertThat(actualRemind).isEqualTo(expectedRemind);
    }
}