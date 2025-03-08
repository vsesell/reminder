package com.serge.reminder.mapper;

import com.serge.reminder.dto.RemindCreateEditDto;
import com.serge.reminder.entity.Remind;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RemindCreateEditMapper {
    Remind map(RemindCreateEditDto remindCreateEditDto);

    Remind map(RemindCreateEditDto remindCreateEditDto,@MappingTarget Remind remind);
}
