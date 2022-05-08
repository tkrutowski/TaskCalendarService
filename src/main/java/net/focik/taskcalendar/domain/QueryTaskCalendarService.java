package net.focik.taskcalendar.domain;

import lombok.RequiredArgsConstructor;
import net.focik.taskcalendar.api.dto.ICalendarEntryDto;
import net.focik.taskcalendar.domain.port.secondary.ICalendarEntryQueryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class QueryTaskCalendarService {

    private final ICalendarEntryQueryRepository calendarEntryRepository;

    public List<ICalendarEntryDto> getCalendarEntriesByDate(LocalDate startDate, int howManyDays) {
        return calendarEntryRepository.getCalendarEntriesByDate(startDate, howManyDays);
    }

    public List<ICalendarEntryDto> getCalendarEntriesByDateAndIdTeam(LocalDate startDate, int howManyDays, int idTeam) {
        List<ICalendarEntryDto> calendarEntriesByDate = calendarEntryRepository.getCalendarEntriesByDate(startDate, howManyDays);

        List<ICalendarEntryDto> collect = calendarEntriesByDate.stream()
                .filter(entryDto -> idTeam == entryDto.getTeamID())
                .collect(Collectors.toList());
        return collect;
    }
}
