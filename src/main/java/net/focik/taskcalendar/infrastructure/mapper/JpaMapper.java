package net.focik.taskcalendar.infrastructure.mapper;

import net.focik.taskcalendar.domain.ICalendarEntry;
import net.focik.taskcalendar.infrastructure.dto.EntryDbDto;
import org.springframework.stereotype.Component;

@Component
public class JpaMapper {

    public EntryDbDto toDto(ICalendarEntry entry){

        return EntryDbDto.builder()
                .idEntry(entry.getIdEntry())
                .idTask(entry.getIdTask())
                .idTeam(entry.getIdTeam())
                .taskType(entry.getTaskType())
                .date(entry.getDate())
                .sentMailPgnStatus(entry.getSentMailPgnStatus())
                .sentMailToCustomerStatus(entry.getSentMailToCustomerStatus())
                .sentMailToSurveyorStatus(entry.getSentMailToSurveyorStatus())
                .postDatePgn(entry.getPostDatePgn())
                .postDateCustomer(entry.getPostDateCustomer())
                .postDateSurveyor(entry.getPostDateSurveyor())
                .message(entry.getMessage())
                .build();
    }

}
