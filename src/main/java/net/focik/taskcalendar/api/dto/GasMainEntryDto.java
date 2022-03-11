package net.focik.taskcalendar.api.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Builder(access = AccessLevel.PUBLIC)
public class GasMainEntryDto implements ICalendarEntryDto {
    private Integer idEntry;
    private Integer idTask;
    private Integer idTeam;
    private String taskType;
    private LocalDate date;
    private String message;

    private String sentMailToSurveyor;
    private LocalDate dateSentMailToSurveyor;

    private Integer idSurveyor;
    private String address;
    private String taskNo;
}
