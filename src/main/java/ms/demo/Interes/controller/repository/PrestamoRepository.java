package ms.demo.Interes.controller.repository;

import ms.demo.Interes.controller.entity.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
    List<Prestamo> DayAndCliente(String day, String cliente);

    List<Prestamo> findByCliente(String cliente);
}
