package net.focik.taskcalendar.infrastructure.clients;

import net.focik.taskcalendar.infrastructure.dto.CustomerDto;
import net.focik.taskcalendar.infrastructure.dto.TeamDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class EmployeeClientTest {

//    EmployeeClient employeeClientMock = mock(EmployeeClient.class);
//
//    @Autowired
//    EmployeeClient employeeClient;
//
//    @Test
//    void findTeamById_mock() {
//        //when
//        final Integer id = 1;
//        when(employeeClientMock.findTeamById(id)).thenReturn(java.util.Optional.of(new TeamDto(1, "Tomek")));
//
//        //given
//        TeamDto teamDto = employeeClientMock.findTeamById(id).get();
//
//        //then
//        assertEquals(id, teamDto.getIdTeam());
//        assertTrue("Tomek".equals(teamDto.getName()));
//    }
//
//    @Test
//    void findTeamById() {
//        //when
//        final Integer id = 1;
//
//        //given
//        TeamDto teamDto = employeeClient.findTeamById(id).get();
//
//        //then
//        assertEquals(id, teamDto.getIdTeam());
//    }
}