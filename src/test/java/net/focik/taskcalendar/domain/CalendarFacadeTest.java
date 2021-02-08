package net.focik.taskcalendar.domain;

import net.focik.taskcalendar.domain.share.TaskType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CalendarFacadeTest {

    @Autowired
    EntryFactory entryFactory;

    @Test
    void should_return_GasConnectionEntry_when_TaskType_given() {
        //when
        final Integer idTask = 1;
        final Integer idTeam = 1;
        final TaskType taskType = TaskType.PRZYLACZE;

        //given
        ICalendarEntry result = entryFactory.createCalendarEntry(taskType, idTask, idTeam);

        assertEquals(GasConnectionEntry.class, result.getClass());

        //then
    }
}