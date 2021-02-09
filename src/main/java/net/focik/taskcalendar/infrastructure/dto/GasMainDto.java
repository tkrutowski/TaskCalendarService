package net.focik.taskcalendar.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GasMainDto {
    private Integer idTask;
    private Integer idSurveyor;
    private String taskNo;
    private AddressDto address;
}
