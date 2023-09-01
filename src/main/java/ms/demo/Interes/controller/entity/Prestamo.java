package ms.demo.Interes.controller.entity;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_clietne")
    private Long id;
    @Column(name = "fecha")
    private String day;
    //private LocalDate day;
    @Column(name = "monto")
    private Integer monto;
    @Column(name = "estado")
    private Boolean pagado;
    @Column(name = "cliente")
    private String cliente;

    public Prestamo() {
    }

    public Prestamo(Long id, String day, Integer monto, Boolean pagado, String cliente) {
        this.id = id;
        this.day = day;
        this.monto = monto;
        this.pagado = pagado;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public Boolean getPagado() {
        return pagado;
    }

    public void setPagado(Boolean pagado) {
        this.pagado = pagado;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
}
