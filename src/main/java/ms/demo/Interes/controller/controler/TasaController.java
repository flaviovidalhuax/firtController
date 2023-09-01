package ms.demo.Interes.controller.controler;

import ms.demo.Interes.controller.entity.Tasas;
import ms.demo.Interes.controller.service.TasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class TasaController {
    @Autowired
    TasaService tasaService;
    @PostMapping("/saveTasa")
    public Tasas guardarTasa(@RequestBody Tasas tasas){
        return tasaService.guardarTasa(tasas);
    }
    @GetMapping("/TasaAll")
    public List<Tasas> buscarTados(){
        return tasaService.buscarTodos();
    }

}
