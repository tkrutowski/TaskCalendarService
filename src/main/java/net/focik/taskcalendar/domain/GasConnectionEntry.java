package net.focik.taskcalendar.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.focik.taskcalendar.domain.share.GasCabinetProviderType;
import net.focik.taskcalendar.domain.share.MailStatus;
import net.focik.taskcalendar.domain.share.TaskType;

import java.time.LocalDate;

//@Builder
//@NoArgsConstructor
@Setter
@Getter
class GasConnectionEntry implements ICalendarEntry {
    private Integer idEntry;
    private Integer idTask;
    private Integer idTeam;
    private TaskType taskType;
    private LocalDate date;
    private Address address;
//    private string Adres2 { get; set; }//gazociag 2 linie
    private GasCabinetProviderType gasCabinetProvider;
    private boolean isPgn;
    private String info;
    private MailStatus sentMailToSurveyor;
    private MailStatus sentMailToCustomer;
    private MailStatus sentMailPgn;
    private Integer idSurveyor;
    private Integer idCustomer;
    private String taskNo;
}
