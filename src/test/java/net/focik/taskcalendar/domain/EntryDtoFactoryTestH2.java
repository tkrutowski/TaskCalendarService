package net.focik.taskcalendar.domain;

import net.focik.taskcalendar.domain.port.IAddressRepository;
import net.focik.taskcalendar.domain.port.IGasConnectionRepository;
import net.focik.taskcalendar.domain.port.IGasMainRepository;
import net.focik.taskcalendar.domain.share.GasCabinetProviderType;
import net.focik.taskcalendar.domain.share.TaskType;
//import net.focik.taskcalendar.infrastructure.clients.GasConnectionRepositoryAdapter;
//import net.focik.taskcalendar.infrastructure.clients.GasMainRepositoryAdapter;
import net.focik.taskcalendar.infrastructure.dto.AddressDto;
import net.focik.taskcalendar.infrastructure.dto.EntryDto;
import net.focik.taskcalendar.infrastructure.dto.GasConnectionDto;
import net.focik.taskcalendar.infrastructure.dto.GasMainDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
//@SpringBootTest
class EntryDtoFactoryTestH2 {

    @Mock
    IGasConnectionRepository gasConnectionRepositoryMock;// = mock(GasConnectionRepositoryAdapter.class);
    @Mock
    IGasMainRepository gasMainRepositoryMock;// = mock(GasMainRepositoryAdapter.class);
    @Mock
    IAddressRepository addressRepositoryMock;
    @InjectMocks
    EntryDtoFactory entryDtoFactory = new EntryDtoFactory(gasConnectionRepositoryMock, gasMainRepositoryMock, addressRepositoryMock);
   // @Qualifier("calendarEntryRepositoryAdapter")
   // @Autowired
    //ICalendarEntryRepository calendarEntryRepository;

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
        //List<EntryDto> entryDtos = calendarEntryRepository.GetCalendarEntriesByDate(date);
        //given
        //int result = entryDtoFactory.createCalendarEntries(entryDtos).size();

        //then
        //assertEquals(size, result);
    }
    @Test
    void should_return_GasConnectionEntryDto_when_entryDto_przylaczeType_given() {
        //given
        final int size = 1;
        when(gasConnectionRepositoryMock.findGasConnectionById(1)).thenReturn(Optional.of(createGasConnectionDto_1()));
//        when(gasConnectionRepositoryMock.findGasConnectionById(2)).thenReturn(Optional.of(createGasConnectionDto_2()));
//        when(gasConnectionRepositoryMock.findGasConnectionById(3)).thenReturn(Optional.of(createGasConnectionDto_3()));
     //   when(gasMainRepositoryMock.findGasMainById(1)).thenReturn(Optional.of(createGasMainDto_1()));
//        when(gasMainRepositoryMock.findGasMainById(2)).thenReturn(Optional.of(createGasMainDto_2()));
        when(addressRepositoryMock.findAddressById(1)).thenReturn(Optional.of(createAddresDto()));
        List<EntryDto> entryDtos = new ArrayList<>();
       // entryDtos.add(createEntryDtoGazociag());
        entryDtos.add(createEntryDtoPrzylacze());
        //when
        ICalendarEntry result = entryDtoFactory.createCalendarEntries(entryDtos).get(0);

        //then
        assertTrue(result instanceof GasConnectionEntry);
    }

    private GasConnectionDto createGasConnectionDto_1(){
        GasConnectionDto dto = new GasConnectionDto();
        dto.setIdTask(1);
        dto.setIdAddress(1);
        dto.setGasCabinetProvider(GasCabinetProviderType.CUSTOMER);
       // dto.setAddress(new AddressDto("Poznań","Pobiedziska", "Armii Poznań 39"));

        return dto;
    }

    private GasConnectionDto createGasConnectionDto_2(){
        GasConnectionDto dto = new GasConnectionDto();
        dto.setIdTask(2);
        dto.setIdAddress(1);
        dto.setGasCabinetProvider(GasCabinetProviderType.PSG);

        //dto.setAddress(new AddressDto("Poznań","Pobiedziska", "Armii Poznań 39"));

        return dto;
    }

    private GasConnectionDto createGasConnectionDto_3(){
        GasConnectionDto dto = new GasConnectionDto();
        dto.setIdTask(3);
        dto.setGasCabinetProvider(GasCabinetProviderType.COMPANY);
        dto.setIdAddress(1);
        //dto.setAddress(new AddressDto("Poznań","Pobiedziska", "Armii Poznań 39"));

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

    private EntryDto createEntryDtoPrzylacze(){
        EntryDto dto=new EntryDto();
        dto.setIdTask(1);
        dto.setIdTeam(5);
        dto.setTaskType(TaskType.PRZYLACZE);
        dto.setDate(LocalDate.of(2020,02,21));
        return dto;
    }
    private EntryDto createEntryDtoGazociag(){
        EntryDto dto=new EntryDto();
        dto.setIdTask(1);
        dto.setIdTeam(5);
        dto.setTaskType(TaskType.GAZOCIAG);
        dto.setDate(LocalDate.of(2020,02,21));
        return dto;
    }
    private AddressDto createAddresDto(){
        return new AddressDto("Gniezno","Pobiedziska","Armii Poznań 39");

    }

}