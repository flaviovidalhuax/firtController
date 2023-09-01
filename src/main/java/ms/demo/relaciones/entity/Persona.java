package ms.demo.relaciones.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


    @Entity
    @Data       ///get y seter constructor  equals
    @NoArgsConstructor  //constructor  vacio
    @AllArgsConstructor     //constructor parametros
    public class Persona {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id_persona")
        private Long id;
        @Column(name = "nombre")
        private String nombre;

        @OneToOne( mappedBy = "persona")
        private Pasaporte pasaporte;

    }

