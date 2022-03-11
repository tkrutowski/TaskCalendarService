package net.focik.taskcalendar.infrastructure.query;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import net.focik.taskcalendar.api.dto.ICalendarEntryDto;
import net.focik.taskcalendar.domain.port.secondary.ICalendarEntryQueryRepository;
import net.focik.taskcalendar.infrastructure.dto.EntryQueryDbDto;
import net.focik.taskcalendar.infrastructure.mapper.QueryMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Log
class CalendarEntryQueryRepositoryAdapter implements ICalendarEntryQueryRepository {

    private final ITaskCalendarQueryDtoRepository calendarDtoRepository;
    private final QueryMapper queryMapper;

    @Override
    public List<ICalendarEntryDto> getCalendarEntriesByDate(LocalDate date, int howManyDays) {
        log.info("CalendarEntryQueryRepositoryAdapter: Try find CalendarEntry in db between "+date + " and " + date.plusDays(howManyDays-1));
        List<EntryQueryDbDto> allByDateBetweenOrderByDate = calendarDtoRepository.findAllByDateBetweenOrderByDate(date, date.plusDays(howManyDays-1));
        log.info("Found: "+ allByDateBetweenOrderByDate.size());
        return allByDateBetweenOrderByDate.stream()
                .map(dbDto -> queryMapper.toDto(dbDto))
                .collect(Collectors.toList());
    }

}
