package net.focik.taskcalendar.infrastructure.clients;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.focik.gasmain.api.internal.GasMainEndpoint;
import net.focik.gasmain.domain.share.DtoType;
import net.focik.taskcalendar.domain.port.secondary.IGasMainRepository;
import net.focik.taskcalendar.infrastructure.dto.GasMainDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import java.util.Optional;


@RequiredArgsConstructor
@Component
@Log4j2
class GasMainRepositoryAdapter implements IGasMainRepository {

    private final GasMainEndpoint gasMainEndpoint;
    private final ModelMapper mapper;

    public Optional<GasMainDto> findGasMainById(Integer id) {
            log.info("TASKCALENDAR-SERVICE: Try find gasmain for  id = " + id);
        GasMainDto gasMainDto = null;
        try {
            gasMainDto = mapper.map(gasMainEndpoint.getGasMain(id, DtoType.TASK_CALENDAR),GasMainDto.class);
            log.info(gasMainDto != null ? "TASKCALENDAR-SERVICE: Found gasmain for id = " + id : "TASKCALENDAR-SERVICE: Not found gasmain for id = " + id);
        }catch (RestClientException ex){
            //TODO może rzucić wyjątek
            log.error("GasMainRepositoryAdapter findGasMainById. Message: "+ex.getMessage());
            return Optional.empty();
        }

        return Optional.ofNullable(gasMainDto);
    }

}
