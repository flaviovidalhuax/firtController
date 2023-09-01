package ms.demo.relaciones.entity.relOneMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ms.demo.relaciones.entity.relOneMany.Equipo;

import javax.persistence.*;

@Entity
@Data       ///get y seter constructor  equals
@NoArgsConstructor  //constructor  vacio
@AllArgsConstructor
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_jugador")
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "id_equipo")
    private Equipo equipo;
}
