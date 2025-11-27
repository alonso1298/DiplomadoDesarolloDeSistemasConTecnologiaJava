package mx.unam.dgtic.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "boletos")
public class Boleto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_boleto")
    private int idBoleto;

    @ManyToOne
    @JoinColumn(name = "id_funcion")
    private Funcion funcion;

    @Column
    private String asiento;

    @Column(name = "fecha_compra")
    private LocalDateTime fechaCompra;

    public Boleto(){}

    public Boleto(int idBoleto, Funcion funcion, String asiento, LocalDateTime fechaCompra) {
        this.idBoleto = idBoleto;
        this.funcion = funcion;
        this.asiento = asiento;
        this.fechaCompra = fechaCompra;
    }

    public int getIdBoleto() {
        return idBoleto;
    }

    public void setIdBoleto(int idBoleto) {
        this.idBoleto = idBoleto;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public LocalDateTime getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDateTime fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    @Override
    public String toString() {
        return "Boleto{" +
                "idBoleto=" + idBoleto +
                ", funcion=" + funcion +
                ", asiento=" + asiento +
                ", fechaCompra=" + fechaCompra +
                '}';
    }
}
