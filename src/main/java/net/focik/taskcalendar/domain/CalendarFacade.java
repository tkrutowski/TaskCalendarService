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

    EntryDtoFactory entryDtoFactory;
    ICalendarEntryRepository calendarEntryRepository;

    public List<ICalendarEntry> getCalendarEntriesByDate(LocalDate startDate, int howManyDays ) {
        int i=0;
        List<EntryDto> entryDtos = calendarEntryRepository.GetCalendarEntriesByDate(startDate, howManyDays);
        return entryDtoFactory.createCalendarEntries(entryDtos);

    }
}
