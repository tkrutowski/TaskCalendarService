package net.focik.taskcalendar.domain;

import lombok.AllArgsConstructor;
import net.focik.taskcalendar.domain.port.ICalendarEntryRepository;
import net.focik.taskcalendar.domain.share.MailStatus;
import net.focik.taskcalendar.domain.share.NotificationClient;
import net.focik.taskcalendar.infrastructure.dto.EntryDbDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskCalendarService {

    ICalendarEntryRepository calendarEntryRepository;


    public Boolean saveInfoMsg(Integer idEntry, String msg) {
        Optional<EntryDbDto> entryDbDto = calendarEntryRepository.GetCalendarEntry(idEntry);

        if(entryDbDto.isEmpty())
            return false;

        EntryDbDto entryDto = entryDbDto.get();

        entryDto.setMessage(msg);

        calendarEntryRepository.save(entryDto);

        return true;
    }
}
