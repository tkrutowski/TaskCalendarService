package net.focik.taskcalendar.domain.exceptions;

public class CalendarEntryDoesNotExistException extends ObjectDoesNotExistException {
    public CalendarEntryDoesNotExistException(Integer id) {
        super("CalendarEntry with id = " + id + " does not exist");
    }

}
