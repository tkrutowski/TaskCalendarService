package net.focik.taskcalendar.domain;

import net.focik.taskcalendar.domain.port.IAddressRepository;
import net.focik.taskcalendar.domain.port.ICalendarEntryRepository;
import net.focik.taskcalendar.domain.port.IGasConnectionRepository;
import net.focik.taskcalendar.domain.port.IGasMainRepository;
import net.focik.taskcalendar.domain.share.TaskType;
import net.focik.taskcalendar.infrastructure.dto.AddressDto;
import net.focik.taskcalendar.infrastructure.dto.GasConnectionDto;
import net.focik.taskcalendar.infrastructure.dto.GasMainDto;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
class CalendarFacadeTest {

    @Mock
    IGasConnectionRepository gasConnectionRepositoryMock;// = mock(GasConnectionRepositoryAdapter.class);
    @Mock
    IGasMainRepository gasMainRepositoryMock;// = mock(GasMainRepositoryAdapter.class);
    @Mock
    IAddressRepository addressRepositoryMock;
    @InjectMocks
    EntryDtoFactory entryDtoFactory = new EntryDtoFactory(gasConnectionRepositoryMock, gasMainRepositoryMock, addressRepositoryMock);

    @Qualifier("calendarEntryRepositoryAdapter")
    @Autowired
    ICalendarEntryRepository calendarEntryRepository;

//    @Autowired
//    CalendarFacade calendarFacade;
//    CalendarFacade calendarFacade = new CalendarFacade(entryDtoFactory,calendarEntryRepository);



    @Test
    void should_return_size4_when_2021_02_22_given() {
        //when
        final int size = 3;
        CalendarFacade calendarFacade = new CalendarFacade(entryDtoFactory,calendarEntryRepository);
        LocalDate date =  LocalDate.of(2021, 02, 22);
         when(gasConnectionRepositoryMock.findGasConnectionById(1)).thenReturn(Optional.of(createGasConnectionDto_1()));
        when(gasConnectionRepositoryMock.findGasConnectionById(2)).thenReturn(Optional.of(createGasConnectionDto_2()));
//        when(gasConnectionRepositoryMock.findGasConnectionById(3)).thenReturn(Optional.of(createGasConnectionDto_3()));
        when(gasMainRepositoryMock.findGasMainById(1)).thenReturn(Optional.of(createGasMainDto_1()));
//        when(gasMainRepositoryMock.findGasMainById(2)).thenReturn(Optional.of(createGasMainDto_2()));
//        when(addressRepositoryMock.findAddressById(1)).thenReturn(Optional.of(createAddresDto()));
//        when(addressRepositoryMock.findAddressById(1)).thenReturn(Optional.of(createAddresDto()));
        //given
        int result = calendarFacade.getCalendarEntriesByDate(date,1).size();

        //then
        assertEquals(size, result);
    }

    private GasConnectionDto createGasConnectionDto_1(){
        GasConnectionDto dto = new GasConnectionDto();
        dto.setIdTask(1);
        dto.setAddress("");
        dto.setGasCabinetProvider("Klient");
        dto.setIdCustomer(1);
        dto.setIdSurveyor(1);
        return dto;
    }

    private GasConnectionDto createGasConnectionDto_2(){
        GasConnectionDto dto = new GasConnectionDto();
        dto.setIdTask(1);
        dto.setAddress("");
        dto.setGasCabinetProvider("Progas");
        dto.setIdCustomer(1);
        dto.setIdSurveyor(1);
        return dto;
    }

    private GasConnectionDto createGasConnectionDto_3(){
        GasConnectionDto dto = new GasConnectionDto();
        dto.setIdTask(1);
        dto.setAddress("");
        dto.setGasCabinetProvider("PSG");
        dto.setIdCustomer(1);
        dto.setIdSurveyor(1);
        return dto;
    }

    private AddressDto createAddresDto() {
        return new AddressDto("Gniezno", "Pobiedziska", "Armii Poznań 39");
    }

    private GasMainDto createGasMainDto_1(){
        GasMainDto dto = new GasMainDto();
        dto.setIdTask(1);
//        dto.setIdAddress(1);

        return dto;
    }

    private GasMainDto createGasMainDto_2(){
        GasMainDto dto = new GasMainDto();
        dto.setIdTask(1);
//        dto.setIdAddress(2);
//
        return dto;
    }
}