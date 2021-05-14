package net.focik.taskcalendar.domain;

import lombok.AllArgsConstructor;
import net.focik.taskcalendar.domain.port.ICalendarEntryRepository;
import net.focik.taskcalendar.domain.share.MailStatus;
import net.focik.taskcalendar.domain.share.NotificationClient;
import net.focik.taskcalendar.infrastructure.dto.EntryDbDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NotificationStatusService {

    ICalendarEntryRepository calendarEntryRepository;


    public Boolean updateMailStatus(Integer idEntry, MailStatus mailStatus, LocalDate updateDate, NotificationClient notificationClient) {
        Optional<EntryDbDto> entryDbDto = calendarEntryRepository.GetCalendarEntry(idEntry);

        if(entryDbDto.isEmpty())
            return false;

        EntryDbDto entryDto = entryDbDto.get();

        switch (notificationClient) {
            case CUSTOMER:
                entryDto.setSentMailToCustomerStatus(mailStatus);
                entryDto.setPostDateCustomer(updateDate);
                break;
            case SURVEYOR:
                entryDto.setSentMailToSurveyorStatus(mailStatus);
                entryDto.setPostDateSurveyor(updateDate);
                break;
            case PGN:
                entryDto.setSentMailPgnStatus(mailStatus);
                entryDto.setPostDatePgn(updateDate);
                break;
        }

        calendarEntryRepository.save(entryDto);

        return true;
    }
}
