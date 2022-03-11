package net.focik.taskcalendar.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CalendarFacade {

    private final TaskCalendarService calendarService;

    public List<ICalendarEntry> getCalendarEntriesByDate(LocalDate startDate, int howManyDays ) {
        return  calendarService.getCalendarEntriesByDate(startDate, howManyDays);
    }


    public boolean changeInfoMessage(Integer idEntry, String msg) {
        return calendarService.saveInfoMsg(idEntry,msg);
    }
}
