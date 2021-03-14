package net.focik.taskcalendar.domain;

import lombok.AllArgsConstructor;
import net.focik.taskcalendar.domain.port.ICalendarEntryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class CalendarFacade {

    EntryDtoFactory entryDtoFactory;
    ICalendarEntryRepository calendarEntryRepository;

    public List<ICalendarEntry> getCalendarEntriesByDate(LocalDate startDate, int howManyDays ) {
        return entryDtoFactory.createCalendarEntries(calendarEntryRepository.GetCalendarEntriesByDate(startDate, howManyDays));

    }
}
