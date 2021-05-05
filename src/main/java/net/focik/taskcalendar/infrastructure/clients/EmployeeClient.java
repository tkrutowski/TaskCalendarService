package net.focik.taskcalendar.infrastructure.clients;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import net.focik.taskcalendar.infrastructure.dto.TeamDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
@AllArgsConstructor
class EmployeeClient {
    private RestTemplate restTemplate;
    //TODO dodać stałą z propertisów
    private static final String URI = "http://employee-service/api/teams/";

    public Optional<TeamDto> findTeamById(Integer id) {
        TeamDto teamDto = null;
        try {
            teamDto = restTemplate.getForObject(URI + id, TeamDto.class);
        }catch (RestClientException ex){
            //TODO może rzucić wyjątek
            return Optional.empty();
        }

        return Optional.ofNullable(teamDto);
    }
}
