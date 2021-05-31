package net.focik.taskcalendar.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import net.focik.taskcalendar.domain.share.MailStatus;
import net.focik.taskcalendar.domain.share.TaskType;

import java.time.LocalDate;

@Setter
@Getter
@Builder(access = AccessLevel.PACKAGE)
class GasMainEntry implements ICalendarEntry{
    private Integer idEntry;
    private Integer idTask;
    private Integer idTeam;
    private TaskType taskType;
    private LocalDate date;
    private String message;

    private MailStatus sentMailToSurveyor;
    private LocalDate dateSentMailToSurveyor;

    private Integer idSurveyor;
    private String address;
    private String taskNo;
}
