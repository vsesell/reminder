package com.serge.reminder.repository;

import com.serge.reminder.entity.Remind;
import jakarta.persistence.Tuple;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RemindRepository extends JpaRepository<Remind,Long>,
        RemindRepositoryCustom {
    Page<Remind> findAll(Pageable pageable);


    @Query("select r.id as id," +
            "r.title as title," +
            "r.description as description," +
            "cast(r.remind as date) as date," +
            "cast(r.remind as time) as time from Remind r")
    Page<Tuple> findAllWithSort(Pageable pageable);

}
