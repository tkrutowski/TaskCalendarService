package net.focik.taskcalendar.domain.port;

import net.focik.taskcalendar.infrastructure.dto.AddressDto;
import net.focik.taskcalendar.infrastructure.dto.GasConnectionDto;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface IAddressRepository {
    Optional<AddressDto> findAddressById(Integer id);
}