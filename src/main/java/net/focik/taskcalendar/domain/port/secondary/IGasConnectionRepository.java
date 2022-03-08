package net.focik.taskcalendar.domain.port.secondary;

import net.focik.taskcalendar.infrastructure.dto.GasConnectionDto;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface IGasConnectionRepository {

    Optional<GasConnectionDto> findGasConnectionById(Integer id);
}
