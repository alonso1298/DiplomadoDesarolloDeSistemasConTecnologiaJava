package Ejercicio1.entity;

import jakarta.persistence.*;


import java.time.LocalDate;

@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clave;
    private String nombre;
    private String marca;
    private Double precio;
    @Column(name = "fecha_alta")
    private LocalDate fechaAlta;

    public Producto(){
    }

    public Producto(Integer clave, String nombre, String marca, Double precio, LocalDate fechaAlta) {
        this.clave = clave;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.fechaAlta = fechaAlta;
    }

    public Integer getClave() {
        return clave;
    }

    public void setClave(Integer clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "clave=" + clave +
                ", nombre='" + nombre + '\'' +
                ", marca='" + marca + '\'' +
                ", precio=" + precio +
                ", fechaAlta=" + fechaAlta +
                '}';
    }
}
