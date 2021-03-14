package net.focik.taskcalendar.api;

import lombok.AllArgsConstructor;
import net.focik.taskcalendar.domain.CalendarFacade;
import net.focik.taskcalendar.domain.ICalendarEntry;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/taskcalendar/")
public class TaskCalendarController {

CalendarFacade calendarFacade;

    @GetMapping("week")
    @CrossOrigin
    public ResponseEntity<List<ICalendarEntry>> getCalendarEntryByWeek(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate){
        List<ICalendarEntry> calendarEntriesByDate = calendarFacade.getCalendarEntriesByDate(startDate, 6);
        return new ResponseEntity<>(calendarEntriesByDate, HttpStatus.OK);

    }
}
