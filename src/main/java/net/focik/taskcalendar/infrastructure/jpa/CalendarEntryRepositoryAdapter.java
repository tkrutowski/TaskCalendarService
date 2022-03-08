package net.focik.taskcalendar.infrastructure.jpa;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import net.focik.taskcalendar.domain.port.secondary.ICalendarEntryRepository;
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
        log.info("CalendarEntryRepositoryAdapter: Try find CalendarEntry in db between "+date + " and " + date.plusDays(howManyDays-1));
        List<EntryDbDto> allByDateBetweenOrderByDate = calendarDtoRepository.findAllByDateBetweenOrderByDate(date, date.plusDays(howManyDays-1));
        log.info("Found: "+ allByDateBetweenOrderByDate.size());
        return allByDateBetweenOrderByDate;
    }

    @Override
    public Optional<EntryDbDto> GetCalendarEntry(int idEntry) {
        log.info("GetCalendarEntriesByDate: Try find CalendarEntry in db by ID = "+ idEntry);
        Optional<EntryDbDto> byId = calendarDtoRepository.findById(idEntry);

        if (byId.isPresent()) {
            log.info("Found:CalendarEntry in db by ID = " + idEntry);
        } else {
            log.info("NOT Found:CalendarEntry in db by ID = " + idEntry);
        }

        return byId;
    }

    @Override
    public EntryDbDto save(EntryDbDto entryDto) {
        log.info("GetCalendarEntriesByDate: Try save CalendarEntry into db ID = "+ entryDto.getIdEntry());
        EntryDbDto saved = calendarDtoRepository.save(entryDto);
        log.info("GetCalendarEntriesByDate: Saved CalendarEntry into db ID = "+ entryDto.getIdEntry());
        return saved;
    }
}
