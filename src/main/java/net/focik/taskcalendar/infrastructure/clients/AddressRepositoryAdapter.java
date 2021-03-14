package net.focik.taskcalendar.infrastructure.clients;

import net.focik.taskcalendar.domain.port.IAddressRepository;
import net.focik.taskcalendar.infrastructure.dto.AddressDto;
import net.focik.taskcalendar.infrastructure.dto.CustomerDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class AddressRepositoryAdapter implements IAddressRepository {
    private RestTemplate restTemplate = new RestTemplate();
    //TODO dodać stałą z propertisów
    private static final String URI = "http://localhost:8085/api/address/type/";
    @Override
    public Optional<AddressDto> findAddressById(Integer id) {
        AddressDto addressDto = null;
        try {
            addressDto = restTemplate.getForObject(URI + id + "?type=TASK_CALENDAR", AddressDto.class);
        }catch (RestClientException ex){
            //TODO może rzucić wyjątek albo legger error
            return Optional.empty();
        }

        return Optional.ofNullable(addressDto);
    }
}
