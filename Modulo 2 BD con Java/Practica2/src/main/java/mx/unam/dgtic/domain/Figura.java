package mx.unam.dgtic.domain;

import java.util.Date;

public class Figura {
    private int id;
    private String nombre;
    private String  descripcion;
    private Date fechaLanzamiento;
    private double precio;
    private int idFabricante;
    private int idEdicion;

    public Figura(int id, String nombre, String descripcion, Date fechaLanzamiento, double precio, int idFabricante, int idEdicion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaLanzamiento = fechaLanzamiento;
        this.precio = precio;
        this.idFabricante = idFabricante;
        this.idEdicion = idEdicion;
    }

    public Figura(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getIdFabricante() {
        return idFabricante;
    }

    public void setIdFabricante(int idFabricante) {
        this.idFabricante = idFabricante;
    }

    public int getIdEdicion() {
        return idEdicion;
    }

    public void setIdEdicion(int idEdicion) {
        this.idEdicion = idEdicion;
    }

    @Override
    public String toString() {
        return "Figura " +
                "id = " + id +
                " nombre = " + nombre + '\'' +
                " descripcion = " + descripcion + '\'' +
                " fechaLanzamiento = " + fechaLanzamiento +
                " precio = " + precio +
                " idFabricante = " + idFabricante +
                " idEdicion = " + idEdicion;
    }
}
