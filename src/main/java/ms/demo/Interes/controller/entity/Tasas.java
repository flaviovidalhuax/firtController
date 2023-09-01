package ms.demo.Interes.controller.entity;

import javax.persistence.*;
import java.sql.Date;
import java.time.MonthDay;

@Entity
public class Tasas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_tasa")
    private Long id;
    @Column(name = "Plazo_min")
    private Integer min;
    @Column(name = "Plazo_max")
    private Integer max;
    @Column(name = "Tasa_interez")
    private Double interes;

    public Tasas() {
    }

    public Tasas(Long id, Integer min, Integer max, Double interes) {
        this.id = id;
        this.min = min;
        this.max = max;
        this.interes = interes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Double getInteres() {
        return interes;
    }

    public void setInteres(Double interes) {
        this.interes = interes;
    }
}
