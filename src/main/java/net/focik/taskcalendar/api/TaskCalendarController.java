package net.focik.taskcalendar.api;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.focik.taskcalendar.domain.CalendarFacade;
import net.focik.taskcalendar.domain.ICalendarEntry;
import net.focik.taskcalendar.domain.share.MailStatus;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@RestController
@AllArgsConstructor
@RequestMapping("/api/taskcalendar/")
public class TaskCalendarController {

CalendarFacade calendarFacade;
private static final int HOW_MANY_DAYS = 6;;

    @GetMapping("week")
//    @CrossOrigin
    public ResponseEntity<List<ICalendarEntry>> getCalendarEntryByWeek(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate){
        log.info("TASKCALENDAR-SERVIE: Get entry between "+startDate + " and " + startDate.plusDays(HOW_MANY_DAYS-1));

        List<ICalendarEntry> calendarEntriesByDate = calendarFacade.getCalendarEntriesByDate(startDate, HOW_MANY_DAYS);
        return new ResponseEntity<>(calendarEntriesByDate, HttpStatus.OK);

    }

}
