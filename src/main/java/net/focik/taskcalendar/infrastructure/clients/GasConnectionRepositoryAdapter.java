package net.focik.taskcalendar.infrastructure.clients;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.focik.gasconnection.api.internal.GasConnectionEndpoint;
import net.focik.gasconnection.domain.share.DtoType;
import net.focik.taskcalendar.domain.port.secondary.IGasConnectionRepository;
import net.focik.taskcalendar.infrastructure.dto.GasConnectionDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import java.util.Optional;

@RequiredArgsConstructor
@Component
@Log4j2
class GasConnectionRepositoryAdapter implements IGasConnectionRepository {

    private final GasConnectionEndpoint gasConnectionEndpoint;
    private final ModelMapper mapper;

    public Optional<GasConnectionDto> findGasConnectionById(Integer id) {
        log.info("TASKCALENDAR-SERVICE: Try find gasconnection for  id = " + id);
        GasConnectionDto gasConnectionDto = null;
        try {
            gasConnectionDto = mapper.map(gasConnectionEndpoint.getGasConnection(id, DtoType.TASK_CALENDAR),GasConnectionDto.class);

            log.info(gasConnectionDto != null ? "TASKCALENDAR-SERVICE: Found gasconnection for id = " + id : "TASKCALENDAR-SERVICE: Not found gasconnection for id = " + id);
        }catch (RestClientException ex){
            //TODO może rzucić wyjątek
            log.error("TASKCALENDAR-SERVICE: GasConnectionRepositoryAdapter findGasConnectionById. Message: "+ex.getMessage());
            return Optional.empty();
        }

        return Optional.ofNullable(gasConnectionDto);
    }

}
