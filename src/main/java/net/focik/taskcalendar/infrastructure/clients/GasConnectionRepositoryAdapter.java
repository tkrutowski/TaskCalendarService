package net.focik.taskcalendar.infrastructure.clients;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.focik.taskcalendar.domain.port.IGasConnectionRepository;
import net.focik.taskcalendar.infrastructure.dto.GasConnectionDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
@AllArgsConstructor
@Log4j2
class GasConnectionRepositoryAdapter implements IGasConnectionRepository {

    private RestTemplate restTemplate;

    //TODO dodać stałą z propertisów
    private static final String URI = "http://gasconnection-service/api/gasconnection/";

    @HystrixCommand(fallbackMethod = "getFallbackGasConnectionDto",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "4000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "6"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
            },
            threadPoolKey = "scopePool",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "20"),
                    @HystrixProperty(name = "maxQueueSize", value = "10")
            })
    public Optional<GasConnectionDto> findGasConnectionById(Integer id) {
        log.info("TASKCALENDAR-SERVICE: Try find gasconnection for  id = " + id);
        GasConnectionDto connectionDto = null;
        try {
            connectionDto = restTemplate.getForObject(URI + id+"?type=TASK_CALENDAR", GasConnectionDto.class);
            log.info(connectionDto != null ? "TASKCALENDAR-SERVICE: Found gasconnection for id = " + id : "TASKCALENDAR-SERVICE: Not found gasconnection for id = " + id);
        }catch (RestClientException ex){
            //TODO może rzucić wyjątek
            log.error("TASKCALENDAR-SERVICE: GasConnectionRepositoryAdapter findGasConnectionById. Message: "+ex.getMessage());
            return Optional.empty();
        }

        return Optional.ofNullable(connectionDto);
    }


    public Optional<GasConnectionDto> getFallbackGasConnectionDto(Integer id) {
        GasConnectionDto connectionDto = new GasConnectionDto();
        connectionDto.setIdTask(id);
        connectionDto.setGasCabinetProvider("Brak danych - fallback");
        connectionDto.setAddress("Brak danych - fallback");
        return Optional.ofNullable(connectionDto);
    }
}
