package net.focik.taskcalendar.domain.port.secondary;

import net.focik.taskcalendar.domain.ICalendarEntry;
import net.focik.taskcalendar.infrastructure.dto.EntryDbDto;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public interface ICalendarEntryRepository {
    List<EntryDbDto> getCalendarEntriesByDate(LocalDate date, int howManyDays);

    Integer save(ICalendarEntry entry);

    Optional<EntryDbDto> getCalendarEntryById(int idEntry);

//    EntryDbDto save(EntryDbDto entryDto);
}