package net.focik.taskcalendar.domain.port.secondary;

import net.focik.taskcalendar.api.dto.ICalendarEntryDto;

import java.time.LocalDate;
import java.util.List;

public interface ICalendarEntryQueryRepository {
    List<ICalendarEntryDto> getCalendarEntriesByDate(LocalDate date, int howManyDays);
}
