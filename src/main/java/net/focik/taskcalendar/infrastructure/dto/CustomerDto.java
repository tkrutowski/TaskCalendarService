package net.focik.taskcalendar.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Value;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerDto {
    private Integer id;
    private String fullName;
    private String phone;
    private String mail;
}
