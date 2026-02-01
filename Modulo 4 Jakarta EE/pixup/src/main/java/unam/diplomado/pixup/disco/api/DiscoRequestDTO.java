package unam.diplomado.pixup.disco.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.jetbrains.annotations.NotNull;

public class DiscoRequestDTO {

    @NotBlank
    @Positive
    private String titulo;

    @NotNull
    @Positive
    private Integer artistaId;

    @NotNull
    @Positive
    private Integer disqueraId;

    @NotNull
    @Positive
    private Integer generoId;

    @NotNull
    @Positive
    private Double precio;

    public DiscoRequestDTO(int id, @NotBlank(message = "El titulo no puede estar vacio") String titulo, @Positive(message = "El precio no puede ser menor que 0") float precio, String nombre, String nombre1, String descripcion) {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @NotNull
    public Integer getArtistaId() {
        return artistaId;
    }

    public void setArtistaId(@NotNull Integer artistaId) {
        this.artistaId = artistaId;
    }

    @NotNull
    public Integer getDisqueraId() {
        return disqueraId;
    }

    public void setDisqueraId(@NotNull Integer disqueraId) {
        this.disqueraId = disqueraId;
    }

    @NotNull
    public Integer getGeneroId() {
        return generoId;
    }

    public void setGeneroId(@NotNull Integer generoId) {
        this.generoId = generoId;
    }

    @NotNull
    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(@NotNull Double precio) {
        this.precio = precio;
    }
}
