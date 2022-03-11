package net.focik.taskcalendar.application;

import lombok.RequiredArgsConstructor;
import net.focik.taskcalendar.domain.CalendarFacade;
import net.focik.taskcalendar.domain.port.primary.IChangeMessageUseCase;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ChangeMessageAppService implements IChangeMessageUseCase {

    private final CalendarFacade facade;

    @Override
    public boolean saveInfoMsg(Integer idEntry, String msg) {
        return facade.changeInfoMessage(idEntry, msg);

    }
}
