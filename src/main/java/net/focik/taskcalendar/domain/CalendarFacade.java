package net.focik.taskcalendar.domain;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import net.focik.taskcalendar.domain.port.secondary.ICalendarEntryRepository;
import net.focik.taskcalendar.domain.share.MailStatus;
import net.focik.taskcalendar.infrastructure.dto.EntryDbDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CalendarFacade {

    private final EntryDtoFactory entryDtoFactory;

    public List<ICalendarEntry> getCalendarEntriesByDate(LocalDate startDate, int howManyDays ) {
        int i=0;
        return entryDtoFactory.createCalendarEntries(startDate, howManyDays);

    }


}
