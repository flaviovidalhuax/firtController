package ms.demo.Interes.controller.service;

import ms.demo.Interes.controller.entity.Tasas;
import ms.demo.Interes.controller.repository.TasaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TasaService {
    @Autowired
    TasaRepository tasaRepository;
    public Tasas guardarTasa( Tasas tasas){
        return tasaRepository.save(tasas);
    }
    public List<Tasas> buscarTodos(){
        return tasaRepository.findAll();
    }


}
