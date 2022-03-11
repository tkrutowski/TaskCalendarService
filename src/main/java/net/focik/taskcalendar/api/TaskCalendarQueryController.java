package net.focik.taskcalendar.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.focik.taskcalendar.domain.QueryCalendarFacade;
import net.focik.taskcalendar.api.dto.ICalendarEntryDto;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

//    @CrossOrigin
@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/taskcalendar/query")
public class TaskCalendarQueryController {

    private final QueryCalendarFacade queryCalendarFacade;
    private final int HOW_MANY_DAYS = 6;


    @GetMapping("week")
    public ResponseEntity<List<ICalendarEntryDto>> getCalendarEntryByWeek(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate){
        int i=0;
        log.info("TASKCALENDAR-SERVIE: Try get CalendarEntry between "+startDate + " and " + startDate.plusDays(HOW_MANY_DAYS-1));

        List<ICalendarEntryDto> calendarEntriesByDate = queryCalendarFacade.getCalendarEntriesByDate(startDate, HOW_MANY_DAYS);
        return new ResponseEntity<>(calendarEntriesByDate, HttpStatus.OK);

    }

}
