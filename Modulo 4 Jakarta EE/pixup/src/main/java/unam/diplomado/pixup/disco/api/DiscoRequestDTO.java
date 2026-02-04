package unam.diplomado.pixup.disco.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class DiscoRequestDTO {

    @NotBlank(message = "El titulo no puede estar vacío")
    @Size(min = 1, max = 255)
    private String titulo;

    @NotNull
    @Positive
    private Double precio;

    @NotNull
    @Positive
    private Integer existencias;

    @NotNull
    @Positive
    private Integer artistaId;

    @NotNull
    @Positive
    private Integer disqueraId;

    @NotNull
    private LocalDate fechaLanzamiento;

    @NotNull
    @Positive
    private Integer generoId;

    // 🔴 Constructor vacío OBLIGATORIO para JSON-B
    public DiscoRequestDTO() {
    }

    // ===== getters y setters =====

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getExistencias() {
        return existencias;
    }

    public void setExistencias(Integer existencias) {
        this.existencias = existencias;
    }

    public Integer getArtistaId() {
        return artistaId;
    }

    public void setArtistaId(Integer artistaId) {
        this.artistaId = artistaId;
    }

    public Integer getDisqueraId() {
        return disqueraId;
    }

    public void setDisqueraId(Integer disqueraId) {
        this.disqueraId = disqueraId;
    }

    public Integer getGeneroId() {
        return generoId;
    }

    public void setGeneroId(Integer generoId) {
        this.generoId = generoId;
    }

    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }
}