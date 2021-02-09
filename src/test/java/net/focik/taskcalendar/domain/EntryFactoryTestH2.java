package net.focik.taskcalendar.domain;

import net.focik.taskcalendar.domain.port.ICalendarEntryRepository;
import net.focik.taskcalendar.domain.port.IGasConnectionRepository;
import net.focik.taskcalendar.domain.port.IGasMainRepository;
import net.focik.taskcalendar.infrastructure.clients.GasConnectionRepositoryAdapter;
import net.focik.taskcalendar.infrastructure.clients.GasMainRepositoryAdapter;
import net.focik.taskcalendar.infrastructure.dto.AddressDto;
import net.focik.taskcalendar.infrastructure.dto.EntryDto;
import net.focik.taskcalendar.infrastructure.dto.GasConnectionDto;
import net.focik.taskcalendar.infrastructure.dto.GasMainDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
@SpringBootTest
class EntryFactoryTestH2 {

    IGasConnectionRepository gasConnectionRepositoryMock = mock(GasConnectionRepositoryAdapter.class);
    IGasMainRepository gasMainRepositoryMock = mock(GasMainRepositoryAdapter.class);
    EntryFactory entryFactory = new EntryFactory(gasConnectionRepositoryMock, gasMainRepositoryMock);
    @Qualifier("calendarEntryRepositoryAdapter")
    @Autowired
    ICalendarEntryRepository calendarEntryRepository;

    @Test
    void should_return_size3_when_2020_02_20_given() {
        //when
        final int size = 3;
        LocalDate date =  LocalDate.of(2020, 02, 20);
        when(gasConnectionRepositoryMock.findGasConnectionById(1)).thenReturn(Optional.of(createGasConnectionDto_1()));
        when(gasConnectionRepositoryMock.findGasConnectionById(2)).thenReturn(Optional.of(createGasConnectionDto_2()));
        when(gasConnectionRepositoryMock.findGasConnectionById(3)).thenReturn(Optional.of(createGasConnectionDto_3()));
        when(gasMainRepositoryMock.findGasMainById(1)).thenReturn(Optional.of(createGasMainDto_1()));
        when(gasMainRepositoryMock.findGasMainById(2)).thenReturn(Optional.of(createGasMainDto_2()));
        List<EntryDto> entryDtos = calendarEntryRepository.GetCalendarEntriesByDate(date);
        //given
        int result = entryFactory.createCalendarEntries(entryDtos).size();

        //then
        assertEquals(size, result);
    }

    private GasConnectionDto createGasConnectionDto_1(){
        GasConnectionDto dto = new GasConnectionDto();
        dto.setIdTask(1);
        dto.setAddress(new AddressDto("Poznań","Pobiedziska", "Armii Poznań 39"));

        return dto;
    }

    private GasConnectionDto createGasConnectionDto_2(){
        GasConnectionDto dto = new GasConnectionDto();
        dto.setIdTask(1);
        dto.setAddress(new AddressDto("Poznań","Pobiedziska", "Armii Poznań 39"));

        return dto;
    }

    private GasConnectionDto createGasConnectionDto_3(){
        GasConnectionDto dto = new GasConnectionDto();
        dto.setIdTask(1);
        dto.setAddress(new AddressDto("Poznań","Pobiedziska", "Armii Poznań 39"));

        return dto;
    }

    private GasMainDto createGasMainDto_1(){
        GasMainDto dto = new GasMainDto();
        dto.setIdTask(1);
        dto.setAddress(new AddressDto("Poznań","Pobiedziska", "Armii Poznań 39"));

        return dto;
    }

    private GasMainDto createGasMainDto_2(){
        GasMainDto dto = new GasMainDto();
        dto.setIdTask(1);
        dto.setAddress(new AddressDto("Poznań","Pobiedziska", "Armii Poznań 39"));

        return dto;
    }
}