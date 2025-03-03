package com.serge.reminder.mapper;

import com.serge.reminder.dto.RemindReadDto;
import com.serge.reminder.entity.Remind;
import org.springframework.stereotype.Component;
@Component
public class RemindReadMapper implements Mapper<Remind, RemindReadDto> {

    @Override
    public RemindReadDto map(Remind object) {
        return new RemindReadDto(
                object.getId(),
                object.getTitle(),
                object.getDescription(),
                object.getRemind()
        );
    }
}
