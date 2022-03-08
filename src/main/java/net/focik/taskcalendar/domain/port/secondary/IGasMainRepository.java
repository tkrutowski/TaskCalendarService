package net.focik.taskcalendar.domain.port.secondary;

import net.focik.taskcalendar.infrastructure.dto.GasConnectionDto;
import net.focik.taskcalendar.infrastructure.dto.GasMainDto;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface IGasMainRepository {
    Optional<GasMainDto> findGasMainById(Integer id);
}

