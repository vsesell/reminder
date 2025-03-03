package com.serge.reminder.repository;

import com.serge.reminder.entity.Remind;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemindRepository extends JpaRepository<Remind,Long> {
}
