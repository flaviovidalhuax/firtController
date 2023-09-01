package ms.demo.Interes.controller.controler;

import ms.demo.Interes.controller.entity.Prestamo;
import ms.demo.Interes.controller.service.PrestamoService;
import ms.demo.QueryData.Prueva;
import ms.demo.dto.RespDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")// para poder pedir en react
@RestController
@RequestMapping
public class PrestamoController {
    @Autowired
    PrestamoService prestamoService;
    @PostMapping("/savePrestamo")
    public Prestamo guardarPrestamo(@RequestBody Prestamo prestamo){
        return prestamoService.guardarPrestamo(prestamo);
    }
    @GetMapping("/prestamosAll")
    public List<Prestamo> buscarTodos(){
        return prestamoService.buscarTodos();
    }
    @GetMapping("/Cliente/{cliente}")
    public List<Object> DayAndCliente( @PathVariable String cliente){
        return prestamoService.byCliente(cliente);
    }

    @GetMapping("/dayAndCliente/{day}/{cliente}")
    public List<RespDto> DayAndCliente(@PathVariable String day, @PathVariable String cliente){
        return prestamoService.DayAndCliente(day,cliente);
    }

}
