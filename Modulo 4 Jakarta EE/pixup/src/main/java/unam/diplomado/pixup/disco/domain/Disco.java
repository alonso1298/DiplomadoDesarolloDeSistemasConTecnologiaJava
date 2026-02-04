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

    @NotBlank
    private String titulo;

    @Positive
    private float precio;

    private int existencia;

    private float descuento;

    @Column(name = "fecha_lanzamiento", nullable = false)
    private LocalDateTime fechaDeLanzamiento;

    @Column(nullable = false)
    private String imagen;

    @ManyToOne
    @JoinColumn(name = "id_disquera", nullable = false)
    private Disquera disquera;

    @ManyToOne
    @JoinColumn(name = "id_artista", nullable = false)
    private Artista artista;

    @ManyToOne
    @JoinColumn(name = "id_genero_musical", nullable = false)
    private GeneroMusical generoMusical;
}