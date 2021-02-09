package net.focik.taskcalendar.domain;

import lombok.AllArgsConstructor;
import net.focik.taskcalendar.domain.port.ICalendarEntryRepository;
import net.focik.taskcalendar.infrastructure.dto.EntryDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class CalendarFacade {

    EntryFactory entryFactory;
    ICalendarEntryRepository calendarEntryRepository;

    List<ICalendarEntry> createCalendarEntriesByDate(LocalDate date) {
        return entryFactory.createCalendarEntries(calendarEntryRepository.GetCalendarEntriesByDate(date));

    }
}
