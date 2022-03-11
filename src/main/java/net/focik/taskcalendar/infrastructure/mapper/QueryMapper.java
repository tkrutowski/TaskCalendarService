package net.focik.taskcalendar.infrastructure.mapper;

import net.focik.taskcalendar.api.dto.GasConnectionEntryDto;
import net.focik.taskcalendar.api.dto.GasMainEntryDto;
import net.focik.taskcalendar.api.dto.ICalendarEntryDto;
import net.focik.taskcalendar.infrastructure.dto.EntryQueryDbDto;
import org.springframework.stereotype.Component;

@Component
public class QueryMapper {

    public ICalendarEntryDto toDto(EntryQueryDbDto dbDto){

        ICalendarEntryDto entryDto = null;

        switch (dbDto.getTaskType()) {
            case GAS_MAIN:
                entryDto= createGasMainEntryDto(dbDto);
                break;
            case GAS_CONNECTION:
                entryDto= createGasConnectionEntryDto(dbDto);
                break;
        }

        return entryDto;
    }

    private ICalendarEntryDto createGasMainEntryDto(EntryQueryDbDto dbDto) {
        return GasMainEntryDto.builder()
                .idEntry(dbDto.getIdEntry())
                .idTask(dbDto.getIdTask())
                .idTeam(dbDto.getIdTeam())
                .taskType(dbDto.getTaskType().toString())
                .date(dbDto.getDate())
                .message(dbDto.getMessage())
//                .isPgn(dbDto.getIsPgn())
//                .sentMailPgn(dbDto.getSentMailPgnStatus().toString())
//                .dateSentMailPgn(dbDto.getPostDatePgn())
                .sentMailToSurveyor(dbDto.getSentMailToSurveyorStatus() == null ? null : dbDto.getSentMailToSurveyorStatus().toString())
                .dateSentMailToSurveyor(dbDto.getPostDateSurveyor())
//                .sentMailToCustomer(dbDto.getSentMailToCustomerStatus().toString())
//                .dateSentMailToCustomer(dbDto.getPostDateCustomer())
//                .idCustomer(dbDto.getIdCustomer())
                .idSurveyor(dbDto.getIdSurveyor())
//                .gasCabinetProvider(dbDto.getGasCabinetProvider())
                .taskNo(dbDto.getTaskNo())
                .address(dbDto.getAddress())
                .build();
    }

    private ICalendarEntryDto createGasConnectionEntryDto(EntryQueryDbDto dbDto) {
        return GasConnectionEntryDto.builder()
                .idEntry(dbDto.getIdEntry())
                .idTask(dbDto.getIdTask())
                .idTeam(dbDto.getIdTeam())
                .taskType(dbDto.getTaskType().toString())
                .date(dbDto.getDate())
                .message(dbDto.getMessage())
                .isPgn(dbDto.getIsPgn())
                .sentMailPgn(dbDto.getSentMailPgnStatus() == null ? null : dbDto.getSentMailPgnStatus().toString())
                .dateSentMailPgn(dbDto.getPostDatePgn())
                .sentMailToSurveyor(dbDto.getSentMailToSurveyorStatus() == null ? null : dbDto.getSentMailToSurveyorStatus().toString())
                .dateSentMailToSurveyor(dbDto.getPostDateSurveyor())
                .sentMailToCustomer(dbDto.getSentMailToCustomerStatus() == null ? null : dbDto.getSentMailToCustomerStatus().toString())
                .dateSentMailToCustomer(dbDto.getPostDateCustomer())
                .idCustomer(dbDto.getIdCustomer())
                .idSurveyor(dbDto.getIdSurveyor())
                .gasCabinetProvider(dbDto.getGasCabinetProvider())
                .taskNo(dbDto.getTaskNo())
                .address(dbDto.getAddress())
                .build();

    }
}
