package ms.demo.QueryData;

import ms.demo.dto.RespDto;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prueva {

    public RespDto prueba(LocalDate daynow, String clinteCount, Double interesDecimal, Integer auxDeuda, Double pago) {
        RespDto obj=new RespDto(daynow,clinteCount, interesDecimal,auxDeuda,pago);
        /*Map<String, Object> mapResponce =new HashMap<>();
       mapResponce.put("fecha",daynow );
        mapResponce.put("cliente",clinteCount );
        mapResponce.put("interes",  interesDecimal);
        mapResponce.put("deuda",auxDeuda );
        mapResponce.put("pago",pago);
        System.out.println("mapResponce.get(\"pago\") = " + mapResponce.get("pago"));
        */

        return obj;
    }

}
