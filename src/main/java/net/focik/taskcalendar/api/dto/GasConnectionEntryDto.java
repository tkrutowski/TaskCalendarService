package net.focik.taskcalendar.api.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Builder(access = AccessLevel.PUBLIC)
public class GasConnectionEntryDto implements ICalendarEntryDto {
    private Integer idEntry;
    private Integer idTask;
    private Integer idTeam;
    private String taskType;
    private LocalDate date;
    private String message;
    private Boolean isPgn;

    private String sentMailPgn;
    private LocalDate dateSentMailPgn;

    private String sentMailToSurveyor;
    private LocalDate dateSentMailToSurveyor;

    private LocalDate dateSentMailToCustomer;
    private String sentMailToCustomer;

    private Integer idSurveyor;
    private Integer idCustomer;
    private String address;
    private String gasCabinetProvider;
    private String taskNo;
}
