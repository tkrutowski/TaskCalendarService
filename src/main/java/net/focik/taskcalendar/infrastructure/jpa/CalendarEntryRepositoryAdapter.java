package net.focik.taskcalendar.infrastructure.jpa;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import net.focik.taskcalendar.domain.port.ICalendarEntryRepository;
import net.focik.taskcalendar.infrastructure.dto.EntryDbDto;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
@Log
class CalendarEntryRepositoryAdapter implements ICalendarEntryRepository {

    private ITaskCalendarDtoRepository calendarDtoRepository;

    @Override
    public List<EntryDbDto> GetCalendarEntriesByDate(LocalDate date, int howManyDays) {
        log.info("Get data form db between "+date + " and " + date.plusDays(howManyDays));
        List<EntryDbDto> allByDateBetweenOrderByDate = calendarDtoRepository.findAllByDateBetweenOrderByDate(date, date.plusDays(howManyDays));
        log.info("Found: "+ allByDateBetweenOrderByDate.size());
        return allByDateBetweenOrderByDate;
    }

    @Override
    public Optional<EntryDbDto> GetCalendarEntry(int idEntry) {
        log.info("GetCalendarEntry form db ID = "+ idEntry);
        return calendarDtoRepository.findById(idEntry);
    }

    @Override
    public EntryDbDto save(EntryDbDto entryDto) {
        log.info("Save CalendarEntry into db ID = "+ entryDto.getIdEntry());
        return calendarDtoRepository.save(entryDto);
    }
}
