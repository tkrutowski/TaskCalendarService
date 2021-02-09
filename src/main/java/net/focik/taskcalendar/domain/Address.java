package net.focik.taskcalendar.domain;

import lombok.Getter;
import net.focik.taskcalendar.infrastructure.dto.AddressDto;

@Getter
class Address {
    private String commune;
    private String city;
    private String street;

    public Address(AddressDto dto) {
        this.commune = dto.getCommune();
        this.city = dto.getCity();
        this.street = dto.getStreet();
    }
}
