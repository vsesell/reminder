package com.serge.reminder.mapper;

import com.serge.reminder.dto.RemindCreateEditDto;
import com.serge.reminder.entity.Remind;
import org.springframework.stereotype.Component;

@Component
public class RemindCreateEditMapper implements Mapper<RemindCreateEditDto, Remind> {
    @Override
    public Remind map(RemindCreateEditDto object) {
        Remind remind = new Remind();
        copy(object, remind);
        return remind;
    }

    @Override
    public Remind map(RemindCreateEditDto fromObject, Remind toObject) {
        copy(fromObject,toObject);
        return toObject;
    }

    private void copy(RemindCreateEditDto object, Remind remind) {
        remind.setTitle(object.getTitle());
        remind.setDescription(object.getDescription());
        remind.setRemind(object.getRemind());
    }
}
