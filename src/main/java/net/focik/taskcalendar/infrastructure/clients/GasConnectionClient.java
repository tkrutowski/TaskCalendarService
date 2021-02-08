package net.focik.taskcalendar.infrastructure.clients;

import net.focik.taskcalendar.infrastructure.dto.GasConnectionDto;
import net.focik.taskcalendar.infrastructure.dto.TeamDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class GasConnectionClient {
    private RestTemplate restTemplate = new RestTemplate();
    private static final String URI = "http://localhost:8082/api/team/";

    public Optional<GasConnectionDto> findGasConnectionById(Integer id) {
        GasConnectionDto connectionDto = null;
        try {
            connectionDto = restTemplate.getForObject(URI + id, GasConnectionDto.class);
        }catch (RestClientException ex){
            //TODO może rzucić wyjątek
            return Optional.empty();
        }

        return Optional.ofNullable(connectionDto);
    }
}
