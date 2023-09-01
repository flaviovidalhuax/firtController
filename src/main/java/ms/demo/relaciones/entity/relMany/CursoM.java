package ms.demo.relaciones.entity.relMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CursoM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private  Long id;
    @Column(name="nombre")
    private String nombre;

    @ManyToMany(mappedBy = "curso")
    private List<EstudianteM> estudiante= new ArrayList<>();

}
