package net.focik.taskcalendar.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.focik.taskcalendar.domain.share.GasCabinetProviderType;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GasConnectionDto {
    private Integer idTask;
    private Integer idCustomer;
    private Integer idSurveyor;
    private String taskNo;
    private Boolean isPgn;
    private String gasCabinetProvider;
    private Integer idAddress;
}
