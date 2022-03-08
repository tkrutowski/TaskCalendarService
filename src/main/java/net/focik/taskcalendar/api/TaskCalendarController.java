package net.focik.taskcalendar.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.focik.taskcalendar.domain.CalendarFacade;
import net.focik.taskcalendar.domain.ICalendarEntry;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/taskcalendar/")
public class TaskCalendarController {

    private final CalendarFacade calendarFacade;
    private final int HOW_MANY_DAYS = 6;;

    @GetMapping("week")
//    @CrossOrigin
    public ResponseEntity<List<ICalendarEntry>> getCalendarEntryByWeek(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate){
      int i=0;
        log.info("TASKCALENDAR-SERVIE: Try get CalendarEntry between "+startDate + " and " + startDate.plusDays(HOW_MANY_DAYS-1));

        List<ICalendarEntry> calendarEntriesByDate = calendarFacade.getCalendarEntriesByDate(startDate, HOW_MANY_DAYS);
        return new ResponseEntity<>(calendarEntriesByDate, HttpStatus.OK);

    }

}
