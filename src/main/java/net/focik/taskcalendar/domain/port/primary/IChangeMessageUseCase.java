package net.focik.taskcalendar.domain.port.primary;

public interface IChangeMessageUseCase {
    boolean saveInfoMsg(Integer idEntry, String msg);
}
