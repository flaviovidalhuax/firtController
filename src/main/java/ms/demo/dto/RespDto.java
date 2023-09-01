package ms.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RespDto {

    private LocalDate daynow;
    private String clinteCount;
    private Double interesDecimal;
    private Integer auxDeuda;
    private Double pago;


}
