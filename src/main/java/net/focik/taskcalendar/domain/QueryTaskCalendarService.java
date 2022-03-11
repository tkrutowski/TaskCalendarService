package net.focik.taskcalendar.domain;

import lombok.RequiredArgsConstructor;
import net.focik.taskcalendar.api.dto.ICalendarEntryDto;
import net.focik.taskcalendar.domain.port.secondary.ICalendarEntryQueryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
class QueryTaskCalendarService {

    private final ICalendarEntryQueryRepository calendarEntryRepository;

    public List<ICalendarEntryDto> getCalendarEntriesByDate(LocalDate startDate, int howManyDays) {
        return calendarEntryRepository.getCalendarEntriesByDate(startDate, howManyDays);
    }
}
