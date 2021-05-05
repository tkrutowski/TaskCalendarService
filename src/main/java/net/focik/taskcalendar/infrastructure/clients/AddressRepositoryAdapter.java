package net.focik.taskcalendar.infrastructure.clients;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import net.focik.taskcalendar.domain.port.IAddressRepository;
import net.focik.taskcalendar.infrastructure.dto.AddressDto;
import net.focik.taskcalendar.infrastructure.dto.CustomerDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
@AllArgsConstructor
public class AddressRepositoryAdapter implements IAddressRepository {
    private RestTemplate restTemplate;
    //TODO dodać stałą z propertisów
    private static final String URI = "http://address-service/api/address/type/";

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
