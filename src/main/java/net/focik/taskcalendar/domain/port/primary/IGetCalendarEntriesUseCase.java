package net.focik.taskcalendar.domain.port.primary;

import net.focik.taskcalendar.domain.ICalendarEntry;

import java.time.LocalDate;
import java.util.List;

public interface IGetCalendarEntriesUseCase {
     List<ICalendarEntry> getCalendarEntriesByDate(LocalDate startDate, int howManyDays);
}
