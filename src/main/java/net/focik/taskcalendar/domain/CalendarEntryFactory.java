package net.focik.taskcalendar.domain;

import lombok.RequiredArgsConstructor;
import net.focik.taskcalendar.domain.exceptions.CalendarEntryDoesNotExistException;
import net.focik.taskcalendar.domain.exceptions.GasConnectionDoesNotExistException;
import net.focik.taskcalendar.domain.exceptions.GasMainDoesNotExistException;
import net.focik.taskcalendar.domain.port.secondary.ICalendarEntryRepository;
import net.focik.taskcalendar.domain.port.secondary.IGasConnectionRepository;
import net.focik.taskcalendar.domain.port.secondary.IGasMainRepository;
import net.focik.taskcalendar.infrastructure.dto.EntryDbDto;
import net.focik.taskcalendar.infrastructure.dto.GasConnectionDto;
import net.focik.taskcalendar.infrastructure.dto.GasMainDto;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
class CalendarEntryFactory {

    private final IGasConnectionRepository gasConnectionRepository;
    private final IGasMainRepository gasMainRepository;
    private final ICalendarEntryRepository calendarEntryRepository;

    public List<ICalendarEntry> createCalendarEntries(LocalDate startDate, int howManyDays) {
        List<EntryDbDto> entryDbDtos = calendarEntryRepository.getCalendarEntriesByDate(startDate, howManyDays);

        return createCalendarEntries(entryDbDtos);
    }

    public ICalendarEntry createCalendarEntry(int entryID) {
        Optional<EntryDbDto> entryDbDto = calendarEntryRepository.getCalendarEntryById(entryID);

        if(entryDbDto.isEmpty())
            throw new CalendarEntryDoesNotExistException(entryID);

        return createCalendarEntry(entryDbDto.get());
    }


    private ICalendarEntry  createCalendarEntry(EntryDbDto entryDbDto) {
        return getCalendarEntry(entryDbDto);
    }



    private List<ICalendarEntry>  createCalendarEntries(List<EntryDbDto> entryDbDtoList) {
        List<ICalendarEntry> calendarEntries = new ArrayList<>();

        for (EntryDbDto dto : entryDbDtoList) {
            ICalendarEntry entry = getCalendarEntry(dto);
            if (entry != null)
                calendarEntries.add(entry);
        }

        return calendarEntries;
    }

    private ICalendarEntry getCalendarEntry(EntryDbDto entryDbDto) {
        ICalendarEntry entry = null;
        switch (entryDbDto.getTaskType()) {
            case GAS_CONNECTION:
                entry = createGasConnectionEntry(entryDbDto);
                break;
            case GAS_MAIN:
                entry = createGasMainEntry(entryDbDto);
                break;
        }
        return entry;
    }

    private ICalendarEntry createGasMainEntry(EntryDbDto dto) {
        Optional<GasMainDto> gasMainById = getGasMainDto(dto);

        return GasMainEntry.builder()
                .idEntry(dto.getIdEntry())
                .idTask(dto.getIdTask())
                .idTeam(dto.getIdTeam())
                .taskType(dto.getTaskType())
                .date(dto.getDate())
                .message(dto.getMessage())
                .sentMailToSurveyor(dto.getSentMailToSurveyorStatus())
                .dateSentMailToSurveyor(dto.getPostDateSurveyor())
                .idSurveyor(gasMainById.get().getIdSurveyor())
                .address(gasMainById.get().getAddress())
                .taskNo(gasMainById.get().getTaskNo())
                .build();

    }

    private Optional<GasMainDto> getGasMainDto(EntryDbDto dto) {
        Optional<GasMainDto> gasMainById = gasMainRepository.findGasMainById(dto.getIdTask());

        if (gasMainById.isEmpty())
            throw new GasMainDoesNotExistException(dto.getIdTask());
        return gasMainById;
    }

    private ICalendarEntry createGasConnectionEntry(EntryDbDto dto) {
        Optional<GasConnectionDto> gasConnectionById =  getGasConnectionDto(dto);

        return GasConnectionEntry.builder()
                .idEntry(dto.getIdEntry())
                .idTask(dto.getIdTask())
                .idTeam(dto.getIdTeam())
                .taskType(dto.getTaskType())
                .date(dto.getDate())
                .message(dto.getMessage())
                .sentMailPgn(dto.getSentMailPgnStatus())
                .dateSentMailPgn(dto.getPostDatePgn())
                .sentMailToSurveyor(dto.getSentMailToSurveyorStatus())
                .dateSentMailToSurveyor(dto.getPostDateSurveyor())
                .sentMailToCustomer(dto.getSentMailToCustomerStatus())
                .dateSentMailToCustomer(dto.getPostDateCustomer())
                .idSurveyor(gasConnectionById.get().getIdSurveyor())
                .address(gasConnectionById.get().getAddress())
                .gasCabinetProvider(gasConnectionById.get().getGasCabinetProvider())
                .taskNo(gasConnectionById.get().getTaskNo())
                .isPgn(gasConnectionById.get().getIsPgn())
                .build();
    }

    private Optional<GasConnectionDto> getGasConnectionDto(EntryDbDto dto) {
        Optional<GasConnectionDto> gasConnectionById = gasConnectionRepository.findGasConnectionById(dto.getIdTask());
        if (gasConnectionById.isEmpty())
            throw new GasConnectionDoesNotExistException(dto.getIdTask());
        return gasConnectionById;
    }

}
