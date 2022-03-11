package net.focik.taskcalendar.application;

import lombok.RequiredArgsConstructor;
import net.focik.taskcalendar.api.dto.ICalendarEntryDto;
import net.focik.taskcalendar.domain.CalendarFacade;
import net.focik.taskcalendar.domain.ICalendarEntry;
import net.focik.taskcalendar.domain.QueryCalendarFacade;
import net.focik.taskcalendar.domain.port.primary.IGetCalendarEntriesForDisplayUseCase;
import net.focik.taskcalendar.domain.port.primary.IGetCalendarEntriesUseCase;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@RequiredArgsConstructor
@Service
public class GetCalendarEntryAppService implements IGetCalendarEntriesForDisplayUseCase, IGetCalendarEntriesUseCase {

    private final QueryCalendarFacade queryCalendarFacade;
    private final CalendarFacade calendarFacade;


    @Override
    public List<ICalendarEntryDto> getCalendarEntriesDtoByDate(LocalDate startDate, int howManyDays) {
        return queryCalendarFacade.getCalendarEntriesByDate(startDate, howManyDays);
    }

    @Override
    public List<ICalendarEntry> getCalendarEntriesByDate(LocalDate startDate, int howManyDays) {
        return calendarFacade.getCalendarEntriesByDate(startDate,howManyDays);
    }
}
