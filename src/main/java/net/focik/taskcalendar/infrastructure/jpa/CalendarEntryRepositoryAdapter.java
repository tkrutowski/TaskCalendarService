package net.focik.taskcalendar.infrastructure.jpa;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import net.focik.taskcalendar.domain.port.ICalendarEntryRepository;
import net.focik.taskcalendar.infrastructure.dto.EntryDto;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@AllArgsConstructor
@Log
class CalendarEntryRepositoryAdapter implements ICalendarEntryRepository {

    private ITaskCalendarDtoRepository calendarDtoRepository;

    @Override
    public List<EntryDto> GetCalendarEntriesByDate(LocalDate date, int howManyDays) {
        log.info("Get data form db between "+date + " and " + date.plusDays(howManyDays));
        List<EntryDto> allByDateBetweenOrderByDate = calendarDtoRepository.findAllByDateBetweenOrderByDate(date, date.plusDays(howManyDays));
        log.info("Found: "+ allByDateBetweenOrderByDate.size());
        return allByDateBetweenOrderByDate;
    }
}
