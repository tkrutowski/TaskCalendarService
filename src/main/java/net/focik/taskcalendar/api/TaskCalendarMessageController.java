package net.focik.taskcalendar.api;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.focik.taskcalendar.domain.TaskCalendarService;
import net.focik.taskcalendar.domain.share.NotificationClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Log4j2
@RequestMapping("/api/taskcalendar/msg/")
public class TaskCalendarMessageController {

    TaskCalendarService taskCalendarService;


    @PutMapping("{id}")
//    @CrossOrigin
    public ResponseEntity<Boolean> changeMailStausCustomer(@PathVariable("id") Integer idEntry, @RequestParam("msg") String msg){
        Boolean result = taskCalendarService.saveInfoMsg(idEntry, msg);
        log.info("Update CalendarEntry - message ID = "+ idEntry+ ", message = "+msg);
        return new ResponseEntity<>(result, result? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
