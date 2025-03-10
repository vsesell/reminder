package com.serge.reminder.integration.mapper;

import com.serge.reminder.dto.RemindSortingDto;
import com.serge.reminder.entity.Remind;
import com.serge.reminder.integration.IntegrationTestBase;
import com.serge.reminder.mapper.RemindSortingMapper;
import com.serge.reminder.repository.RemindRepository;
import jakarta.persistence.Tuple;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@RequiredArgsConstructor
public class RemindSortingMapperTest extends IntegrationTestBase {
    private final RemindRepository repository;
    private final RemindSortingMapper remindSortingMapper;
    private static final Pageable DEFAULT_PAGEABLE = Pageable.ofSize(1);

    @Test
     void tupleToDto() {
        Page<Tuple> allWithSort = repository.findAllWithSort(DEFAULT_PAGEABLE);
        Remind remind = new Remind(null, "Meeting with client", "Discussion about new project", LocalDateTime.of(
                2025, 3, 15, 10, 0, 0
        ));

        RemindSortingDto actualResult = allWithSort.map(remindSortingMapper::map).stream().toList().get(0);

        assertAll(
                () -> assertThat(actualResult.getTitle()).isEqualTo(remind.getTitle()),
                () -> assertThat(actualResult.getDescription()).isEqualTo(remind.getDescription()),
                () -> assertThat(actualResult.getDate()).isEqualTo(Date.valueOf(remind.getRemind().toLocalDate())),
                () -> assertThat(actualResult.getTime()).isEqualTo(Time.valueOf(remind.getRemind().toLocalTime()))
        );

    }
}
