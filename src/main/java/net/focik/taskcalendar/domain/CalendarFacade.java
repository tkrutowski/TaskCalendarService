package net.focik.taskcalendar.domain;

import lombok.RequiredArgsConstructor;
import net.focik.taskcalendar.domain.share.MailStatus;
import net.focik.taskcalendar.domain.share.NotificationClient;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CalendarFacade {

    private final TaskCalendarService calendarService;
    private final NotificationStatusService notificationStatusService;

    public List<ICalendarEntry> getCalendarEntriesByDate(LocalDate startDate, int howManyDays) {
        return calendarService.getCalendarEntriesByDate(startDate, howManyDays);
    }


    public boolean changeInfoMessage(Integer idEntry, String msg) {
        return calendarService.saveInfoMsg(idEntry, msg);
    }

    public Boolean updateMailStatus(Integer idEntry, MailStatus mailStatus, LocalDate updateDate, NotificationClient notificationClient) {
        return notificationStatusService.updateMailStatus(idEntry, mailStatus, updateDate, notificationClient);
    }
}
