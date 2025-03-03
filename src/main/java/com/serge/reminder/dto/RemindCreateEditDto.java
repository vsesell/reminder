package com.serge.reminder.dto;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class RemindCreateEditDto {
    String title;
    String description;
    LocalDateTime remind;
}
