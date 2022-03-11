package net.focik.taskcalendar.domain;

import lombok.AccessLevel;
import lombok.Builder;
import net.focik.taskcalendar.domain.share.MailStatus;
import net.focik.taskcalendar.domain.share.TaskType;

import java.time.LocalDate;

@Builder(access = AccessLevel.PACKAGE)
public class GasMainEntry implements ICalendarEntry {
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

    @Override
    public void changeMessage(String msg) {
        message = msg;
    }

    @Override
    public Integer getIdEntry() {
        return idEntry;
    }

    @Override
    public Integer getIdTask() {
        return idTask;
    }

    @Override
    public Integer getIdTeam() {
        return idTeam;
    }

    @Override
    public TaskType getTaskType() {
        return taskType;
    }

    @Override
    public LocalDate getDate() {
        return date;
    }

    @Override
    public MailStatus getSentMailPgnStatus() {
        return MailStatus.NO_NEED;
    }

    @Override
    public LocalDate getPostDatePgn() {
        return null;
    }

    @Override
    public MailStatus getSentMailToSurveyorStatus() {
        return sentMailToSurveyor;
    }

    @Override
    public LocalDate getPostDateSurveyor() {
        return dateSentMailToSurveyor;
    }

    @Override
    public MailStatus getSentMailToCustomerStatus() {
        return MailStatus.NO_NEED;
    }

    @Override
    public LocalDate getPostDateCustomer() {
        return null;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getIdSurveyor() {
        return idSurveyor;
    }


    @Override
    public String getAddress() {
        return null;
    }

    @Override
    public String getTaskNo() {
        return null;
    }

    @Override
    public void setSentMailToCustomerStatus(MailStatus mailStatus) {
        //in the future
    }

    @Override
    public void setPostDateCustomer(LocalDate date) {
        //in the future
    }

    @Override
    public void setSentMailToSurveyorStatus(MailStatus mailStatus) {
        this.sentMailToSurveyor = mailStatus;
    }

    @Override
    public void setPostDateSurveyor(LocalDate date) {
        this.dateSentMailToSurveyor = date;
    }

    @Override
    public void setSentMailPgnStatus(MailStatus mailStatus) {
        //in the future
    }

    @Override
    public void setPostDatePgn(LocalDate date) {
        //in the future
    }
}
