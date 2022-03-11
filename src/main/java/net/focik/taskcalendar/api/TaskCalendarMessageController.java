package net.focik.taskcalendar.api;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.focik.taskcalendar.domain.port.primary.IChangeMessageUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//    @CrossOrigin
@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/api/taskcalendar/msg/")
public class TaskCalendarMessageController {

    private final IChangeMessageUseCase changeMessageUseCase;

    @PutMapping("{id}")
    public ResponseEntity<Boolean> changeMessage(@PathVariable("id") Integer idEntry, @RequestParam("msg") String msg){
        Boolean result = changeMessageUseCase.saveInfoMsg(idEntry, msg);
        log.info("Update CalendarEntry - message ID = "+ idEntry+ ", message = "+msg);
        return new ResponseEntity<>(result, result? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
