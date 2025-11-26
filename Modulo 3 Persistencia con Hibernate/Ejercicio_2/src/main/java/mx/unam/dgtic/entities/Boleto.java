package mx.unam.dgtic.entities;

import jakarta.persistence.*;

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
    private int idFuncion;

    @Column
    private int asiento;

    @Column(name = "fecha_compra")
    private Date fechaCompra;

    public Boleto(){}

    public Boleto(int idBoleto, int idFuncion, int asiento, Date fechaCompra) {
        this.idBoleto = idBoleto;
        this.idFuncion = idFuncion;
        this.asiento = asiento;
        this.fechaCompra = fechaCompra;
    }

    public int getIdBoleto() {
        return idBoleto;
    }

    public void setIdBoleto(int idBoleto) {
        this.idBoleto = idBoleto;
    }

    public int getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(int idFuncion) {
        this.idFuncion = idFuncion;
    }

    public int getAsiento() {
        return asiento;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
}
