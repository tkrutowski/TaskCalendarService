package net.focik.taskcalendar.infrastructure.clients;

import net.focik.taskcalendar.domain.port.IGasConnectionRepository;
import net.focik.taskcalendar.infrastructure.dto.GasConnectionDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
class GasConnectionRepositoryAdapter implements IGasConnectionRepository {

    private RestTemplate restTemplate = new RestTemplate();

    //TODO dodać stałą z propertisów
    private static final String URI = "http://localhost:8090/api/gasconnection/";

    public Optional<GasConnectionDto> findGasConnectionById(Integer id) {
        GasConnectionDto connectionDto = null;
        try {
            connectionDto = restTemplate.getForObject(URI + id+"?type=TASK_CALENDAR", GasConnectionDto.class);
        }catch (RestClientException ex){
            //TODO może rzucić wyjątek
            return Optional.empty();
        }

        return Optional.ofNullable(connectionDto);
    }
}
