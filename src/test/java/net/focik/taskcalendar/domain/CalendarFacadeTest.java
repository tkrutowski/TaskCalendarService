package net.focik.taskcalendar.domain;

import net.focik.taskcalendar.infrastructure.dto.GasConnectionDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CalendarFacadeTest {

//    @Autowired
//    EmployeeClient employeeClientMock = mock(EmployeeClient.class);
//    IGasConnectionRepository gasConnectionRepositoryMock = mock(GasConnectionClient.class);
//    EntryFactory entryFactory = new EntryFactory(gasConnectionRepositoryMock);
//    @Autowired
//    ICalendarEntryRepository calendarEntryRepositoryAdapter;
//    CalendarFacade calendarFacade = new CalendarFacade(entryFactory, calendarEntryRepositoryAdapter);
        @Autowired
    CalendarFacade calendarFacade;

    @Test
    void should_return_size3_when_2020_02_20_given() {
        //when
        final int size = 3;
        LocalDate date =  LocalDate.of(2020, 02, 20);
//        when(gasConnectionRepositoryMock.findGasConnectionById(1)).thenReturn(Optional.of(createGasConnectionDto_1()));
//        when(gasConnectionRepositoryMock.findGasConnectionById(2)).thenReturn(Optional.of(createGasConnectionDto_2()));
//        when(gasConnectionRepositoryMock.findGasConnectionById(3)).thenReturn(Optional.of(createGasConnectionDto_3()));
        //given
        int result = calendarFacade.createCalendarEntriesByDate(date).size();

        //then
        assertEquals(size, result);
    }
//    @Test
//    void should_return_GasConnectionEntry_when_TaskType_given() {
//        //when
//        final Integer idTask = 1;
//        final Integer idTeam = 1;
//        final TaskType taskType = TaskType.PRZYLACZE;
//
//        //given
//        List<ICalendarEntry> calendarEntriesByDate = calendarFacade.createCalendarEntriesByDate(date);
//
//        //then
//        assertEquals(GasConnectionEntry.class, result.getClass());
//    }
//
//    @Test
//    @Ig
//    void should_return_GasConnectionEntry_with_team_name_given() {
//        //when
//        final Integer idTask = 1;
//        final Integer idTeam = 1;
//        final String name = "Tomek";
//        final TaskType taskType = TaskType.PRZYLACZE;
//        when(employeeClientMock.findTeamById(idTeam)).thenReturn(java.util.Optional.of(new TeamDto(idTeam, name)));
//
//        //given
//        ICalendarEntry result = entryFactory.createCalendarEntries(taskType, idTask, idTeam);
//
//        //then
//        assertTrue(name.equals(result.));
//    }

    private GasConnectionDto createGasConnectionDto_1(){
        GasConnectionDto dto = new GasConnectionDto();
        dto.setIdTask(1);

        return dto;
    }

    private GasConnectionDto createGasConnectionDto_2(){
        GasConnectionDto dto = new GasConnectionDto();
        dto.setIdTask(1);

        return dto;
    }

    private GasConnectionDto createGasConnectionDto_3(){
        GasConnectionDto dto = new GasConnectionDto();
        dto.setIdTask(1);

        return dto;
    }
}