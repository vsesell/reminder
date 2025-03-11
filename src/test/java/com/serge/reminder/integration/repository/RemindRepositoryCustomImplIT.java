package com.serge.reminder.integration.repository;

import com.serge.reminder.integration.IntegrationTestBase;
import com.serge.reminder.repository.RemindRepositoryCustomImpl;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.jdbc.Sql;

import java.sql.Date;
import java.sql.Time;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@Sql({
        "classpath:sql/data-for-custom-repo.sql"
})
@RequiredArgsConstructor
class RemindRepositoryCustomImplIT extends IntegrationTestBase {
    private final RemindRepositoryCustomImpl repository;
    private static final Pageable DEFAULT_PAGEABLE_SIZE_80 = Pageable.ofSize(80);
    private static final Date DEFAULT_DATE = Date.valueOf("2024-03-10");
    private static final Time DEFAULT_TIME = Time.valueOf("10:00:00");


    @ParameterizedTest
    @MethodSource("argumentsStreamForFilterTest")
    void filterParametrizedTest(Date date, Time time, Pageable pageable, Long result) {
        long count = repository.findFilterDateTime(date,time,pageable)
                .stream().count();
        assertThat(count).isEqualTo(result);
    }

    static Stream<Arguments> argumentsStreamForFilterTest() {
        return Stream.of(
                Arguments.of(DEFAULT_DATE, null, DEFAULT_PAGEABLE_SIZE_80, 3L),
                Arguments.of(null, DEFAULT_TIME, DEFAULT_PAGEABLE_SIZE_80, 2L),
                Arguments.of(DEFAULT_DATE, DEFAULT_TIME, DEFAULT_PAGEABLE_SIZE_80, 1L)
        );
    }
}