package com.serge.reminder.repository;

import jakarta.persistence.Tuple;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Date;
import java.sql.Time;

public interface RemindRepositoryCustom {
    Page<Tuple> findFilterDateTime(Date date, Time time, Pageable pageable);
}
