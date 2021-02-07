package net.focik.taskcalendar.domain;

import lombok.AllArgsConstructor;
import net.focik.taskcalendar.infrastructure.clients.CustomerClient;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class EntryFactory {
    CustomerClient customerClient;

    public ICalendarEntry createCalendarEntry(){
        ICalendarEntry entry;


        return null;//entry;
    }


}
