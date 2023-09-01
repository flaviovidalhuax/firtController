package ms.demo.Interes.controller.service;
import ch.qos.logback.core.net.server.Client;
import ms.demo.Interes.controller.entity.Prestamo;
import ms.demo.Interes.controller.entity.Tasas;
import ms.demo.Interes.controller.repository.PrestamoRepository;
import ms.demo.Interes.controller.repository.TasaRepository;
import ms.demo.QueryData.Prueva;
import ms.demo.dto.RespDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PrestamoService {
    @Autowired
    PrestamoRepository prestamoRepository;
    @Autowired
    TasaRepository tasaRepository;
    public Prestamo guardarPrestamo(Prestamo prestamo){
        return prestamoRepository.save(prestamo);
    }
    public List<Prestamo> buscarTodos(){
        return prestamoRepository.findAll();
    }
    public List<Object> byCliente( String cliente) {
        Integer aux=0;
        String pattern = "#,##0.00";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        List<Object> info2 = null;

        List<Prestamo> data = prestamoRepository.findByCliente(cliente);
        
        for (Prestamo val : data) {
            Integer pag = val.getMonto();
            boolean edo= val.getPagado();
            System.out.println("edo = " + edo);
            if(edo==false){
                aux+=pag;
            }
            String cli = val.getCliente();
            String dsyprest = val.getDay();//1-04-1992
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate fechaLocalDate = LocalDate.parse(dsyprest, formatter);
            LocalDate daynow = LocalDate.now();//1992-03-18
            long diferenciaEnDias = ChronoUnit.DAYS.between(fechaLocalDate, daynow);
            Long Plazo = diferenciaEnDias;
            
            Long num = 0L;
            if (Plazo == 0) {
                num = 1L;
            } else if (Plazo >= 2 && Plazo <= 7) {
                num = 2L;
            } else if (Plazo >= 8 && Plazo <= 15) {
                num = 3L;
            } else if (Plazo >= 16 && Plazo <= 30) {
                num = 4L;
            } else if (Plazo >= 31 && Plazo <= 360) {
                num = 5L;
            }else {
                num = 5L;
            }
            Optional<Tasas> tasaOp = tasaRepository.findById(num);
            Double taInteres = 0.0;
            if (tasaOp.isPresent()) {
                taInteres = tasaOp.get().getInteres();
            }
            double auxTasa=taInteres/100;
            Double interes = (aux * Plazo * auxTasa) / 360;
            Double iva = interes * .16;
            Double pago = aux + interes + iva;

           // Prueva prueva=new Prueva( pago, iva, interes);
            info2 = new ArrayList<>();
            info2.add( "dia actual= "+daynow);
            info2.add( "cliente= "+ cli);
            info2.add("Tasa Interes: "+decimalFormat.format(auxTasa) );
            info2.add("Monto prestado:" +decimalFormat.format(aux));
            info2.add("Interes: "+decimalFormat.format(interes));
            info2.add("Interes: .16%");
            info2.add("Pago: "+ decimalFormat.format(pago));
        }

        return info2;
    }
    public List<RespDto> DayAndCliente(String day, String cliente) {
        List<RespDto> listRest= new ArrayList<>();
        Integer auxDeuda = 0;
        List<Prestamo> info = prestamoRepository.DayAndCliente(day, cliente);
       
        Prueva prueva = null;
        for (Prestamo data : info) {
            String clinteCount = data.getCliente();
            Integer deuda = data.getMonto();

            Boolean edo = data.getPagado();
            String dayNow = data.getDay();//01-03-1990
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate fechaLocalDate = LocalDate.parse(dayNow, formatter);//cambio de formato
            LocalDate daynow = LocalDate.now();//1992-03-18   presente
            long diferenciaEnDias = ChronoUnit.DAYS.between(fechaLocalDate, daynow);

            if (!edo) {
                auxDeuda += deuda;
            }
            Long Plazo = diferenciaEnDias;

            Long num = 0L;
            if (Plazo == 0) {
                num = 1L;
            } else if (Plazo >= 2 && Plazo <= 7) {
                num = 2L;
            } else if (Plazo >= 8 && Plazo <= 15) {
                num = 3L;
            } else if (Plazo >= 16 && Plazo <= 30) {
                num = 4L;
            } else if (Plazo >= 31 && Plazo <= 360) {
                num = 5L;
            } else {
                num = 5L;
            }
            Optional<Tasas> tasaOp = tasaRepository.findById(num);
            Double intProm = 0.0;
            if (tasaOp.isPresent()) {
                intProm = tasaOp.get().getInteres();
            }
            Double interesDecimal = intProm / 100;
            Double interes = (auxDeuda * Plazo * interesDecimal) / 360;
            Double iva = interes * .16;
            Double pago = auxDeuda + interes + iva;

            //prueva = new Prueva(daynow, clinteCount, interesDecimal, auxDeuda, pago);
            RespDto dto=new RespDto();
            dto.equals(daynow);
            dto.setClinteCount(clinteCount);
            dto.setInteresDecimal(interesDecimal);
            dto.setAuxDeuda(auxDeuda);
            dto.setPago(pago);
            listRest.add(dto);

        }
        return listRest;
    }
}
