package com.serge.reminder.mapper;

import com.serge.reminder.dto.RemindReadDto;
import com.serge.reminder.entity.Remind;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RemindReadMapper {
    RemindReadDto map(Remind remind);
}
