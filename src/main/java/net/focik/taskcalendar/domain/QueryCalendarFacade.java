package net.focik.taskcalendar.domain;

import lombok.RequiredArgsConstructor;
import net.focik.taskcalendar.api.dto.ICalendarEntryDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryCalendarFacade {

    private final QueryTaskCalendarService calendarService;

    public List<ICalendarEntryDto> getCalendarEntriesByDate(LocalDate startDate, int howManyDays ) {

        return calendarService.getCalendarEntriesByDate(startDate, howManyDays);
    }

    public List<ICalendarEntryDto> getCalendarEntriesByDateAndIdTeam(LocalDate startDate, int how_many_days, int idTeam) {
        return calendarService.getCalendarEntriesByDateAndIdTeam(startDate, how_many_days, idTeam);
    }
}
