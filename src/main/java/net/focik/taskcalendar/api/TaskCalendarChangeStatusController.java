package net.focik.taskcalendar.api;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.focik.taskcalendar.domain.port.primary.IChangeNotificationStatusUseCase;
import net.focik.taskcalendar.domain.share.MailStatus;
import net.focik.taskcalendar.domain.share.NotificationClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

//    @CrossOrigin
@RestController
@AllArgsConstructor
@Log4j2
@RequestMapping("/api/taskcalendar/change_status/")
public class TaskCalendarChangeStatusController {

    IChangeNotificationStatusUseCase changeNotificationStatusUseCase;

    @PutMapping("customer/{id}")
    public ResponseEntity<Boolean> changeMailStausCustomer(@PathVariable("id") Integer idEntry,  @RequestParam("status") MailStatus mailStatus,@Nullable @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate updateDate){
        Boolean result = changeNotificationStatusUseCase.updateMailStatus(idEntry, mailStatus, updateDate, NotificationClient.CUSTOMER);
        log.info("Update CalendarEntry - customer ID = "+ idEntry+ ", MAIL_STATUS = "+mailStatus+", date = "+updateDate);
        return new ResponseEntity<>(result, result? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("surveyor/{id}")
    public ResponseEntity<Boolean> changeMailStausSurveyor(@PathVariable("id") Integer idEntry,  @RequestParam("status") MailStatus mailStatus,@Nullable @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate updateDate){
        Boolean result = changeNotificationStatusUseCase.updateMailStatus(idEntry, mailStatus, updateDate, NotificationClient.SURVEYOR);
        log.info("Update CalendarEntry - surveyor ID = "+ idEntry+ ", MAIL_STATUS = "+mailStatus+", date = "+updateDate);
        return new ResponseEntity<>(result, result? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("pgn/{id}")
    public ResponseEntity<Boolean> changeMailStausPgn(@PathVariable("id") Integer idEntry, @RequestParam("status") MailStatus mailStatus,@Nullable @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate updateDate){
        Boolean result = changeNotificationStatusUseCase.updateMailStatus(idEntry, mailStatus, updateDate, NotificationClient.PGN);
        log.info("Update CalendarEntry - pgn ID = "+ idEntry+ ", MAIL_STATUS = "+mailStatus+", date = "+updateDate);
        return new ResponseEntity<>(result, result? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
