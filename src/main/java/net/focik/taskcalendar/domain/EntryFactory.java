package net.focik.taskcalendar.domain;

import lombok.AllArgsConstructor;
import net.focik.taskcalendar.domain.share.TaskType;
import net.focik.taskcalendar.infrastructure.clients.CustomerClient;
import net.focik.taskcalendar.infrastructure.clients.EmployeeClient;
import net.focik.taskcalendar.infrastructure.clients.GasConnectionClient;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class EntryFactory {

    CustomerClient customerClient;
    EmployeeClient employeeClient;
    GasConnectionClient gasConnectionClient;

    public ICalendarEntry createCalendarEntry(TaskType taskType, int idTask, int idTeam) {
        ICalendarEntry entry = null;
        switch (taskType) {
            case PRZYLACZE:
                entry = createGasConnectionEntry(idTask, idTeam);
        }

        return entry;
    }

    private ICalendarEntry createGasConnectionEntry(int idTask, int idTeam) {
        GasConnectionEntry entry = new GasConnectionEntry();
        entry.setIdTask(idTask);
        entry.setIdTeam(idTeam);

        addTeam(entry);
        addCustomer(entry);
        addGasConnection(entry);
        return entry;
    }


}
