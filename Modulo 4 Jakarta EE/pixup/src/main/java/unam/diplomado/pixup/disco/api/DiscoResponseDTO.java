package unam.diplomado.pixup.disco.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class DiscoResponseDTO {

    private Integer id;
    private String titulo;
    private String artista;
    private String disquera;
    private String genero;
    private Double precio;

    public DiscoResponseDTO(int id, @NotBlank(message = "El titulo no puede estar vacio") String titulo, @Positive(message = "El precio no puede ser menor que 0") float precio, int existencia) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getDisquera() {
        return disquera;
    }

    public void setDisquera(String disquera) {
        this.disquera = disquera;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
