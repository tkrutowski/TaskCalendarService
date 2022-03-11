package net.focik.taskcalendar.application;

import lombok.RequiredArgsConstructor;
import net.focik.taskcalendar.domain.CalendarFacade;
import net.focik.taskcalendar.domain.port.primary.IChangeNotificationStatusUseCase;
import net.focik.taskcalendar.domain.share.MailStatus;
import net.focik.taskcalendar.domain.share.NotificationClient;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class UpdateNotificationStatusAppService implements IChangeNotificationStatusUseCase {

    private final CalendarFacade facade;


    @Override
    public Boolean updateMailStatus(Integer idEntry, MailStatus mailStatus, LocalDate updateDate, NotificationClient notificationClient) {
        return facade.updateMailStatus(idEntry, mailStatus, updateDate, notificationClient);
    }
}
