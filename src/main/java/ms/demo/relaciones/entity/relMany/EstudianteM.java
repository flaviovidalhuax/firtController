package ms.demo.relaciones.entity.relMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ms.demo.relaciones.entity.relMany.CursoM;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstudianteM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estidiante")
    private  Long id;
    @Column(name="nombre")
    private String nombre;
    @ManyToMany
    @JoinTable(name="estidiante_curso",
            joinColumns= @JoinColumn(name= "id_estudiante"),
            inverseJoinColumns =@JoinColumn(name= "id_curso") )
    private List<CursoM> curso=new ArrayList<>();
}
