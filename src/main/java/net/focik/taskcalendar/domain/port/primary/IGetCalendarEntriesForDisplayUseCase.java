package net.focik.taskcalendar.domain.port.primary;

import net.focik.taskcalendar.api.dto.ICalendarEntryDto;

import java.time.LocalDate;
import java.util.List;

public interface IGetCalendarEntriesForDisplayUseCase {
     List<ICalendarEntryDto> getCalendarEntriesDtoByDate(LocalDate startDate, int howManyDays);
}
