package net.focik.taskcalendar.domain;

import lombok.AccessLevel;
import lombok.Builder;
import net.focik.taskcalendar.domain.share.MailStatus;
import net.focik.taskcalendar.domain.share.TaskType;

import java.time.LocalDate;


@Builder(access = AccessLevel.PACKAGE)
public class GasConnectionEntry implements ICalendarEntry {
    private Integer idEntry;
    private Integer idTask;
    private Integer idTeam;
    private TaskType taskType;
    private LocalDate date;
    private String message;
    private Boolean isPgn;

    private MailStatus sentMailPgn;
    private LocalDate dateSentMailPgn;

    private MailStatus sentMailToSurveyor;
    private LocalDate dateSentMailToSurveyor;

    private LocalDate dateSentMailToCustomer;
    private MailStatus sentMailToCustomer;

    private Integer idSurveyor;
    private String address;
    private String gasCabinetProvider;
    private String taskNo;

    private String latitude;
    private String longitude;

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
        return sentMailPgn;
    }

    @Override
    public LocalDate getPostDatePgn() {
        return dateSentMailPgn;
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
        return sentMailToCustomer;
    }

    @Override
    public LocalDate getPostDateCustomer() {
        return dateSentMailToCustomer;
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
        return address;
    }

    @Override
    public String getTaskNo() {
        return taskNo;
    }

    @Override
    public void setSentMailToCustomerStatus(MailStatus mailStatus) {
        this.sentMailToCustomer = mailStatus;
    }

    @Override
    public void setPostDateCustomer(LocalDate date) {
        this.dateSentMailToCustomer = date;
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
        this.sentMailPgn = mailStatus;
    }

    @Override
    public void setPostDatePgn(LocalDate date) {
        this.dateSentMailPgn = date;
    }

    public Boolean getIsPgn(){return this.isPgn;}

    public String getGasCabinetProvider() {
        return gasCabinetProvider;
    }
}
