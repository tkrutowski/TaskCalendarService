package net.focik.taskcalendar.domain.port.primary;

import net.focik.taskcalendar.domain.share.MailStatus;
import net.focik.taskcalendar.domain.share.NotificationClient;

import java.time.LocalDate;

public interface IChangeNotificationStatusUseCase {
    Boolean updateMailStatus(Integer idEntry, MailStatus mailStatus, LocalDate updateDate, NotificationClient notificationClient);
}
