package net.focik.taskcalendar.domain;

import lombok.AllArgsConstructor;
import net.focik.taskcalendar.domain.port.secondary.ICalendarEntryRepository;
import net.focik.taskcalendar.domain.share.MailStatus;
import net.focik.taskcalendar.domain.share.NotificationClient;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
class NotificationStatusService {

    private final ICalendarEntryRepository calendarEntryRepository;
    private final CalendarEntryFactory factory;


    public Boolean updateMailStatus(Integer idEntry, MailStatus mailStatus, LocalDate updateDate, NotificationClient notificationClient) {

        ICalendarEntry calendarEntry = factory.createCalendarEntry(idEntry);

        switch (notificationClient) {
            case CUSTOMER:
                calendarEntry.setSentMailToCustomerStatus(mailStatus);
                calendarEntry.setPostDateCustomer(updateDate);
                break;
            case SURVEYOR:
                calendarEntry.setSentMailToSurveyorStatus(mailStatus);
                calendarEntry.setPostDateSurveyor(updateDate);
                break;
            case PGN:
                calendarEntry.setSentMailPgnStatus(mailStatus);
                calendarEntry.setPostDatePgn(updateDate);
                break;
        }

        calendarEntryRepository.save(calendarEntry);

        return true;
    }
}
