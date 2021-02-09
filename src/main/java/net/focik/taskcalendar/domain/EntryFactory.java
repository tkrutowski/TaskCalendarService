package net.focik.taskcalendar.domain;

import lombok.AllArgsConstructor;
import net.focik.taskcalendar.domain.exceptions.GasConnectionDoesNotExistException;
import net.focik.taskcalendar.domain.exceptions.GasMainDoesNotExistException;
import net.focik.taskcalendar.domain.port.IGasConnectionRepository;
import net.focik.taskcalendar.domain.port.IGasMainRepository;
import net.focik.taskcalendar.infrastructure.dto.EntryDto;
import net.focik.taskcalendar.infrastructure.dto.GasConnectionDto;
import net.focik.taskcalendar.infrastructure.dto.GasMainDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
class EntryFactory {

    IGasConnectionRepository gasConnectionRepository;
    IGasMainRepository gasMainRepository;

    public List<ICalendarEntry> createCalendarEntries(List<EntryDto> entryDtoList) {
        List<ICalendarEntry> calendarEntries = new ArrayList<>();

        for (EntryDto dto : entryDtoList) {
            ICalendarEntry entry = null;
            switch (dto.getTaskType()) {
                case PRZYLACZE:
                    entry = createGasConnectionEntry(dto);
                    break;
                case GAZOCIAG:
                    entry = createGasMainEntry(dto);
                    break;
            }
            if (entry != null)
                calendarEntries.add(entry);
        }

        return calendarEntries;
    }

    private ICalendarEntry createGasMainEntry(EntryDto dto) {
        Optional<GasMainDto> gasMainById = gasMainRepository.findGasMainById(dto.getIdTask());

        if (gasMainById.isEmpty())
            throw new GasMainDoesNotExistException(dto.getIdTask());

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
                .address(new Address(gasMainById.get().getAddress()))
                .taskNo(gasMainById.get().getTaskNo())
                .build();
    }

    private ICalendarEntry createGasConnectionEntry(EntryDto dto) {
        Optional<GasConnectionDto> gasConnectionById = gasConnectionRepository.findGasConnectionById(dto.getIdTask());

        if (gasConnectionById.isEmpty())
            throw new GasConnectionDoesNotExistException(dto.getIdTask());

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
                .idCustomer(gasConnectionById.get().getIdCustomer())
                .idSurveyor(gasConnectionById.get().getIdSurveyor())
                .address(new Address(gasConnectionById.get().getAddress()))
                .gasCabinetProvider(gasConnectionById.get().getGasCabinetProvider())
                .taskNo(gasConnectionById.get().getTaskNo())
                .build();
    }
}
