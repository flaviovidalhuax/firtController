package ms.demo.relaciones.entity.relOneMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data       ///get y seter constructor  equals
@NoArgsConstructor  //constructor  vacio
@AllArgsConstructor
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_equipo")
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "equipo")
    private List<Jugador> jugadores = new ArrayList<>();
}
