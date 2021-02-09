package net.focik.taskcalendar.domain.port;

import net.focik.taskcalendar.infrastructure.dto.EntryDto;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public interface ICalendarEntryRepository {
    List<EntryDto> GetCalendarEntriesByDate(LocalDate date);
}
