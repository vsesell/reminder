package com.serge.reminder.mapper;

import com.serge.reminder.dto.RemindSortingDto;
import jakarta.persistence.Tuple;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RemindSortingMapper {
    @Mapping(target = "id", expression = "java(t.get(\"id\",Long.class))")
    @Mapping(target = "title", expression = "java(t.get(\"title\",String.class))")
    @Mapping(target = "description", expression = "java(t.get(\"description\",String.class))")
    @Mapping(target = "date", expression = "java(t.get(\"date\",java.sql.Date.class))")
    @Mapping(target = "time", expression = "java(t.get(\"time\",java.sql.Time.class))")
    RemindSortingDto map(Tuple t);
}
