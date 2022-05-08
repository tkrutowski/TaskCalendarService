package net.focik.taskcalendar.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.focik.taskcalendar.api.dto.ApiMapper;
import net.focik.taskcalendar.api.dto.ICalendarEntryDto;
import net.focik.taskcalendar.domain.ICalendarEntry;
import net.focik.taskcalendar.domain.port.primary.IGetCalendarEntriesUseCase;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

//    @CrossOrigin
@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/taskcalendar/")
public class TaskCalendarController {

    private final IGetCalendarEntriesUseCase getCalendarEntriesUseCase;
    private final int HOW_MANY_DAYS = 6;
    private final ApiMapper apiMapper;

    @GetMapping("week")
    //@PreAuthorize("hasAnyAuthority('TASK_CALENDAR_READ','TASK_CALENDAR_READ_ALL')")
    public ResponseEntity<List<ICalendarEntryDto>> getCalendarEntryByWeek(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate){
        log.info("TASKCALENDAR-SERVIE: Try get CalendarEntry between "+startDate + " and " + startDate.plusDays(HOW_MANY_DAYS-1));

        List<ICalendarEntry> calendarEntriesByDate = getCalendarEntriesUseCase.getCalendarEntriesByDate(startDate, HOW_MANY_DAYS);

        List<ICalendarEntryDto> entryDtos = calendarEntriesByDate.stream()
                .map(apiMapper::toDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(entryDtos, HttpStatus.OK);

    }

}
