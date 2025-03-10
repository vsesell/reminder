package com.serge.reminder.dto;

import lombok.Value;

import java.sql.Date;
import java.sql.Time;

@Value
public class RemindSortingDto {
    Long id;
    String title;
    String description;
    Date date;
    Time time;
}
