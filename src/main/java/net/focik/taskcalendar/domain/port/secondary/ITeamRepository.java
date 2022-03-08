package net.focik.taskcalendar.domain.port.secondary;

import net.focik.taskcalendar.infrastructure.dto.AddressDto;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface ITeamRepository {
    Optional<AddressDto> findAddressById(Integer id);
}
