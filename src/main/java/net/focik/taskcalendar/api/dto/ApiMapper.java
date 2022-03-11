package net.focik.taskcalendar.api.dto;

import net.focik.taskcalendar.domain.GasConnectionEntry;
import net.focik.taskcalendar.domain.GasMainEntry;
import net.focik.taskcalendar.domain.ICalendarEntry;
import org.springframework.stereotype.Component;

@Component
public class ApiMapper {

    public ICalendarEntryDto toDto(ICalendarEntry entry){

        ICalendarEntryDto dto = null;

        switch (entry.getTaskType()) {
            case GAS_MAIN:
                dto= createGasMainEntryDto((GasMainEntry) entry);
                break;
            case GAS_CONNECTION:
                dto= createGasConnectionEntryDto((GasConnectionEntry) entry);
                break;
        }

        return dto;
    }

    private ICalendarEntryDto createGasMainEntryDto(GasMainEntry entry) {
        return GasMainEntryDto.builder()
                .idEntry(entry.getIdEntry())
                .idTask(entry.getIdTask())
                .idTeam(entry.getIdTeam())
                .taskType(entry.getTaskType().toString())
                .date(entry.getDate())
                .message(entry.getMessage())
//                .isPgn(entry.getIsPgn())
//                .sentMailPgn(entry.getSentMailPgnStatus().toString())
//                .dateSentMailPgn(entry.getPostDatePgn())
                .sentMailToSurveyor(entry.getSentMailToSurveyorStatus() == null ? null : entry.getSentMailToSurveyorStatus().toString())
                .dateSentMailToSurveyor(entry.getPostDateSurveyor())
//                .sentMailToCustomer(entry.getSentMailToCustomerStatus().toString())
//                .dateSentMailToCustomer(entry.getPostDateCustomer())
//                .idCustomer(entry.getIdCustomer())
                .idSurveyor(entry.getIdSurveyor())
//                .gasCabinetProvider(entry.getGasCabinetProvider())
                .taskNo(entry.getTaskNo())
                .address(entry.getAddress())
                .build();
    }

    private ICalendarEntryDto createGasConnectionEntryDto(GasConnectionEntry entry) {
        return GasConnectionEntryDto.builder()
                .idEntry(entry.getIdEntry())
                .idTask(entry.getIdTask())
                .idTeam(entry.getIdTeam())
                .taskType(entry.getTaskType().toString())
                .date(entry.getDate())
                .message(entry.getMessage())
                .isPgn(entry.getIsPgn())
                .sentMailPgn(entry.getSentMailPgnStatus() == null ? null : entry.getSentMailPgnStatus().toString())
                .dateSentMailPgn(entry.getPostDatePgn())
                .sentMailToSurveyor(entry.getSentMailToSurveyorStatus() == null ? null : entry.getSentMailToSurveyorStatus().toString())
                .dateSentMailToSurveyor(entry.getPostDateSurveyor())
                .sentMailToCustomer(entry.getSentMailToCustomerStatus() == null ? null : entry.getSentMailToCustomerStatus().toString())
                .dateSentMailToCustomer(entry.getPostDateCustomer())
                .idSurveyor(entry.getIdSurveyor())
                .gasCabinetProvider(entry.getGasCabinetProvider())
                .taskNo(entry.getTaskNo())
                .address(entry.getAddress())
                .build();

    }
}
