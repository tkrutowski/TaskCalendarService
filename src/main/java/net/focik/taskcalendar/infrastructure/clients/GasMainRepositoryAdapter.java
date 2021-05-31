package net.focik.taskcalendar.infrastructure.clients;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.focik.taskcalendar.domain.port.IGasMainRepository;
import net.focik.taskcalendar.infrastructure.dto.GasConnectionDto;
import net.focik.taskcalendar.infrastructure.dto.GasMainDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
@AllArgsConstructor
@Log4j2
class GasMainRepositoryAdapter implements IGasMainRepository {

    private RestTemplate restTemplate = new RestTemplate();

    //TODO dodać stałą z propertisów
    private static final String URI = "http://gasmain-service/api/gasmain/";
//    private static final String URI = "http://gasconnection-service/api/gasconnection/";

    @HystrixCommand(fallbackMethod = "getFallbackGasMainDto",
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
    public Optional<GasMainDto> findGasMainById(Integer id) {
            log.info("TASKCALENDAR-SERVICE: Try find gasmain for  id = " + id);
        GasMainDto gasMainDto = null;
        try {
            gasMainDto = restTemplate.getForObject(URI + id+"?type=TASK_CALENDAR", GasMainDto.class);
            log.info(gasMainDto != null ? "TASKCALENDAR-SERVICE: Found gasmain for id = " + id : "TASKCALENDAR-SERVICE: Not found gasmain for id = " + id);
        }catch (RestClientException ex){
            //TODO może rzucić wyjątek
            log.error("GasMainRepositoryAdapter findGasMainById. Message: "+ex.getMessage());
            return Optional.empty();
        }

        return Optional.ofNullable(gasMainDto);
    }


    public Optional<GasMainDto> getFallbackGasMainDto(Integer id) {
        GasMainDto gasMainDto = new GasMainDto();
        gasMainDto.setIdTask(id);
        gasMainDto.setAddress("Brak danych - fallback");
        return Optional.ofNullable(gasMainDto);
    }
}
