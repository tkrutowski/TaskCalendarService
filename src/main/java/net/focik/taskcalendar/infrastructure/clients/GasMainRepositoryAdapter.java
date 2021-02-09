package net.focik.taskcalendar.infrastructure.clients;

import net.focik.taskcalendar.domain.port.IGasMainRepository;
import net.focik.taskcalendar.infrastructure.dto.GasMainDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class GasMainRepositoryAdapter implements IGasMainRepository {

    private RestTemplate restTemplate = new RestTemplate();

    //TODO dodać stałą z propertisów
    private static final String URI = "http://localhost:8082/api/team/";

    public Optional<GasMainDto> findGasMainById(Integer id) {
        GasMainDto mainDto = null;
        try {
            mainDto = restTemplate.getForObject(URI + id, GasMainDto.class);
        }catch (RestClientException ex){
            //TODO może rzucić wyjątek
            return Optional.empty();
        }

        return Optional.ofNullable(mainDto);
    }
}
