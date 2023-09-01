package ms.demo.relaciones.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pasaporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pasaporte")
    private  Long id;
    @Column(name="numero")
    private String numero;

    @OneToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;
}
