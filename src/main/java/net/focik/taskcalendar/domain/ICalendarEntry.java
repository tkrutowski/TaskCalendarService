package net.focik.taskcalendar.domain;

import net.focik.taskcalendar.domain.share.MailStatus;
import net.focik.taskcalendar.domain.share.TaskType;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public interface ICalendarEntry {
    void changeMessage(String msg);

    Integer getIdEntry();
    Integer getIdTask();
    Integer getIdTeam();
    TaskType getTaskType();
    LocalDate getDate();

    MailStatus getSentMailPgnStatus();
    LocalDate getPostDatePgn();

    MailStatus getSentMailToSurveyorStatus();
    LocalDate getPostDateSurveyor();

    MailStatus getSentMailToCustomerStatus();
    LocalDate getPostDateCustomer();

    String getMessage();
    Integer getIdSurveyor();
    String getAddress();
    String getTaskNo();


    void setSentMailToCustomerStatus(MailStatus mailStatus);
    void setPostDateCustomer(LocalDate date);

    void setSentMailToSurveyorStatus(MailStatus mailStatus);
    void setPostDateSurveyor(LocalDate date);

    void setSentMailPgnStatus(MailStatus mailStatus);
    void setPostDatePgn(LocalDate date);


}
