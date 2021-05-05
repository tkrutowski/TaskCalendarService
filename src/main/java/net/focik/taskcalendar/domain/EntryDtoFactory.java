package net.focik.taskcalendar.domain;

import lombok.AllArgsConstructor;
import net.focik.taskcalendar.domain.exceptions.AddressNotExistException;
import net.focik.taskcalendar.domain.exceptions.GasConnectionDoesNotExistException;
import net.focik.taskcalendar.domain.exceptions.GasMainDoesNotExistException;
import net.focik.taskcalendar.domain.port.IAddressRepository;
import net.focik.taskcalendar.domain.port.IGasConnectionRepository;
import net.focik.taskcalendar.domain.port.IGasMainRepository;
import net.focik.taskcalendar.domain.share.TaskType;
import net.focik.taskcalendar.infrastructure.dto.AddressDto;
import net.focik.taskcalendar.infrastructure.dto.EntryDto;
import net.focik.taskcalendar.infrastructure.dto.GasConnectionDto;
import net.focik.taskcalendar.infrastructure.dto.GasMainDto;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
class EntryDtoFactory {

    IGasConnectionRepository gasConnectionRepository;
    IGasMainRepository gasMainRepository;
    IAddressRepository addressRepository;

    public List<ICalendarEntry> createCalendarEntries(List<EntryDto> entryDtoList) {
        List<ICalendarEntry> calendarEntries = new ArrayList<>();

        for (EntryDto dto : entryDtoList) {
            ICalendarEntry entry = null;
            switch (dto.getTaskType()) {
                case GAS_CONNECTION:
                    entry = createGasConnectionEntry(dto);
                    break;
                case GAS_MAIN:
                    entry = createGasMainEntry(dto);
                    break;
            }
            if (entry != null)
                calendarEntries.add(entry);
        }

        return calendarEntries;
    }

    private ICalendarEntry createGasMainEntry(EntryDto dto) {
//        Optional<GasMainDto> gasMainById = gasMainRepository.findGasMainById(dto.getIdTask());
//
//        if (gasMainById.isEmpty())
//            throw new GasMainDoesNotExistException(dto.getIdTask());
//
//        return GasMainEntry.builder()
//                .idEntry(dto.getIdEntry())
//                .idTask(dto.getIdTask())
//                .idTeam(dto.getIdTeam())
//                .taskType(dto.getTaskType())
//                .date(dto.getDate())
//                .message(dto.getMessage())
//                .sentMailToSurveyor(dto.getSentMailToSurveyorStatus())
//                .dateSentMailToSurveyor(dto.getPostDateSurveyor())
//                .idSurveyor(gasMainById.get().getIdSurveyor())
//                .address(new Address(gasMainById.get().getAddress()))
//                .taskNo(gasMainById.get().getTaskNo())
//                .build();
        return GasMainEntry.builder()
                .idEntry(8)
                .idTask(1)
                .idTeam(2)
                .taskType(TaskType.GAS_MAIN)
                .date( LocalDate.of(2021,3,15))
                .message("fake")
//                .sentMailToSurveyor(dto.getSentMailToSurveyorStatus())
//                .dateSentMailToSurveyor(dto.getPostDateSurveyor())
//                .idSurveyor(gasMainById.get().getIdSurveyor())
//                .address(new Address(gasMainById.get().getAddress()))
//                .taskNo(gasMainById.get().getTaskNo())
                .build();
    }

    private ICalendarEntry createGasConnectionEntry(EntryDto dto) {
        Optional<GasConnectionDto> gasConnectionById = gasConnectionRepository.findGasConnectionById(dto.getIdTask());
        if (gasConnectionById.isEmpty())
            throw new GasConnectionDoesNotExistException(dto.getIdTask());

        Optional<AddressDto> addressById = addressRepository.findAddressById(gasConnectionById.get().getIdAddress());
        if (addressById.isEmpty())
            throw new AddressNotExistException(gasConnectionById.get().getIdAddress());

        return GasConnectionEntry.builder()
                .idEntry(dto.getIdEntry())
                .idTask(dto.getIdTask())
                .idTeam(dto.getIdTeam())
                .taskType(dto.getTaskType())
                .date(dto.getDate())
                .message(dto.getMessage())
//                .sentMailPgn(dto.getSentMailPgnStatus())
//                .dateSentMailPgn(dto.getPostDatePgn())
//                .sentMailToSurveyor(dto.getSentMailToSurveyorStatus())
//                .dateSentMailToSurveyor(dto.getPostDateSurveyor())
//                .sentMailToCustomer(dto.getSentMailToCustomerStatus())
//                .dateSentMailToCustomer(dto.getPostDateCustomer())
                .idCustomer(gasConnectionById.get().getIdCustomer())
                .idSurveyor(gasConnectionById.get().getIdSurveyor())
                .address(addressById.get().getFullAddress())
                .gasCabinetProvider(gasConnectionById.get().getGasCabinetProvider().toString())
                .taskNo(gasConnectionById.get().getTaskNo())
                .isPgn(gasConnectionById.get().getIsPgn())
                .build();
    }
}
