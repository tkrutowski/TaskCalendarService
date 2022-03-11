package net.focik.taskcalendar.domain;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import net.focik.taskcalendar.domain.port.secondary.ICalendarEntryRepository;
import net.focik.taskcalendar.infrastructure.dto.EntryDbDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class TaskCalendarService {

    private final CalendarEntryFactory calendarEntryFactory;
    private final ICalendarEntryRepository calendarEntryRepository;

    public List<ICalendarEntry> getCalendarEntriesByDate(LocalDate startDate, int howManyDays ) {
        return calendarEntryFactory.createCalendarEntries(startDate, howManyDays);

    }

    public Boolean saveInfoMsg(Integer idEntry, String msg) {
        ICalendarEntry calendarEntry = calendarEntryFactory.createCalendarEntry(idEntry);

        calendarEntry.changeMessage(msg);

        calendarEntryRepository.save(calendarEntry);

        return true;
    }
}
