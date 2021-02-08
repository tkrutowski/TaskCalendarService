package net.focik.taskcalendar.domain;

import lombok.AllArgsConstructor;
import net.focik.taskcalendar.domain.share.TaskType;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CalendarFacade {

    EntryFactory entryFactory;

    ICalendarEntry createCalendarEntry(Integer idTask, TaskType taskType, Integer idTeam) {
        return entryFactory.createCalendarEntry(taskType, idTask, idTeam);
    }
}
