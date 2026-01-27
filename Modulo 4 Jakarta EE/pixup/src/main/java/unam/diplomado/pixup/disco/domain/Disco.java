package unam.diplomado.pixup.disco.domain;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Disco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "El titulo no puede estar vacio")
    private String titulo;
    @Positive(message = "El precio no puede ser menor que 0")
    private float precio;
    private int existencia;
    private float descuento;
    @Column(name = "fecha_lanzamiento")
    @JsonbDateFormat("yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime fechaDeLanzamiento;
    private String imagen;
    @ManyToOne
    @JoinColumn(name = "id_disquera", nullable = false)
    @NotNull(message = " La disquera debe estar asociada a un disco")
    private Disquera disquera;
    @ManyToOne
    @JoinColumn(name = "id_artista", nullable = false)
    @NotNull(message = " Un Artista debe estar asociada a un disco")
    private Artista artista;
    @ManyToOne
    @JoinColumn(name = "id_genero_musical", nullable = false)
    @NotNull(message = " Un genero musical debe estar asociada a un disco")
    private GeneroMusical generoMusical;
}