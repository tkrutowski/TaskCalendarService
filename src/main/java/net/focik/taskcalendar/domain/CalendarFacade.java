package net.focik.taskcalendar.domain;

import lombok.AllArgsConstructor;
import net.focik.taskcalendar.domain.port.ICalendarEntryRepository;
import net.focik.taskcalendar.domain.share.MailStatus;
import net.focik.taskcalendar.infrastructure.dto.EntryDbDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CalendarFacade {

    EntryDtoFactory entryDtoFactory;
    ICalendarEntryRepository calendarEntryRepository;

    public List<ICalendarEntry> getCalendarEntriesByDate(LocalDate startDate, int howManyDays ) {
        int i=0;
        List<EntryDbDto> entryDbDtos = calendarEntryRepository.GetCalendarEntriesByDate(startDate, howManyDays);
        return entryDtoFactory.createCalendarEntries(entryDbDtos);

    }

    public Boolean updateCustomerStatus(Integer idEntry, MailStatus mailStatus, LocalDate updateDate) {
        Optional<EntryDbDto> entryDbDto = calendarEntryRepository.GetCalendarEntry(idEntry);

        if(entryDbDto.isEmpty())
            return false;

        EntryDbDto entryDto = entryDbDto.get();
        entryDto.setSentMailToCustomerStatus(mailStatus);
        entryDto.setPostDateCustomer(updateDate);

        calendarEntryRepository.save(entryDto);

        return true;
    }
}
