package net.focik.taskcalendar.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.focik.taskcalendar.domain.share.GasCabinetProviderType;
import net.focik.taskcalendar.domain.share.MailStatus;
import net.focik.taskcalendar.domain.share.TaskType;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tasks_calendar")
public class EntryDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entry")
    private Integer idEntry;
    private Integer idTask;
    private Integer idTeam;
    @Enumerated(EnumType.STRING)
    private TaskType taskType;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    @Column(name = "mail_status_pgn")
    @Enumerated(EnumType.STRING)
    private MailStatus sentMailPgnStatus;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate postDatePgn;

    @Column(name = "mail_status_surveyor")
    @Enumerated(EnumType.STRING)
    private MailStatus sentMailToSurveyorStatus;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate postDateSurveyor;

    @Column(name = "mail_status_customer")
    @Enumerated(EnumType.STRING)
    private MailStatus sentMailToCustomerStatus;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate postDateCustomer;

    private String message;
}
