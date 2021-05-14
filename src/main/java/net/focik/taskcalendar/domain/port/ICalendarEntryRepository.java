package net.focik.taskcalendar.domain.port;

import net.focik.taskcalendar.infrastructure.dto.EntryDbDto;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public interface ICalendarEntryRepository {
    List<EntryDbDto> GetCalendarEntriesByDate(LocalDate date, int howManyDays);
    Optional<EntryDbDto> GetCalendarEntry(int idEntry);

    EntryDbDto save(EntryDbDto entryDto);

}
