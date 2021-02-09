package net.focik.taskcalendar.infrastructure.jpa;

import lombok.AllArgsConstructor;
import net.focik.taskcalendar.domain.port.ICalendarEntryRepository;
import net.focik.taskcalendar.infrastructure.dto.EntryDto;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@AllArgsConstructor
class CalendarEntryRepositoryAdapter implements ICalendarEntryRepository {

    private ITaskCalendarDtoRepository calendarDtoRepository;

    @Override
    public List<EntryDto> GetCalendarEntriesByDate(LocalDate date) {
        return calendarDtoRepository.findAllByDateOrderByDate(date);
    }
}
