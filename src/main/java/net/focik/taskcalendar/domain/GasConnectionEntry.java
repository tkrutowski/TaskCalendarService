package net.focik.taskcalendar.domain;

import net.focik.taskcalendar.domain.share.GasCabinetProviderType;
import net.focik.taskcalendar.domain.share.MailStatus;

import java.time.LocalDate;

class GasConnectionEntry implements ICalendarEntry {
    private Integer idEntry;
    private Integer idTask;
    private Integer idTeam;
//    private TaskType TypeOfTask { get; set; }
    private LocalDate date;
    private Address address;
//    private string Adres2 { get; set; }//gazociag 2 linie
    private GasCabinetProviderType gasCabinetProvider;
    private boolean isPgn;
    private String info;
    private MailStatus sentMailToSurveyor;
    private MailStatus sentMailToCustomer;
    private Integer idSurveyor;
    private Integer idCustomer;
    private String taskNo;
}
