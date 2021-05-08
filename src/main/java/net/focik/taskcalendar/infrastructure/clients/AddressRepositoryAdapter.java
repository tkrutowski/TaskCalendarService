package net.focik.taskcalendar.infrastructure.clients;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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

    @HystrixCommand(fallbackMethod = "getFallbackAddressDto",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "6"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
            },
            threadPoolKey = "scopePool",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "20"),
                    @HystrixProperty(name = "maxQueueSize", value = "10")
            })
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

    
    public Optional<AddressDto> getFallbackAddressDto(Integer id) {
        AddressDto addressDto = new AddressDto();
        addressDto.setCity("fallback");
        addressDto.setCommune("fallback");
        addressDto.setStreet("fallback");

        return Optional.ofNullable(addressDto);
    }



}
