package unam.diplomado.pixup.disco.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Disco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;
    private float precio;
    private int existencia;
    private float descuento;
    @Column(name = "fecha_de_lanzamiento")
    private Date fechaDeLanzamiento;
    private String imagen;
    @ManyToOne
    @JoinColumn(name = "disquera", nullable = false)
    @NotNull(message = " La disquera debe estar asociada a un disco")
    private Disquera disquera;
    @ManyToOne
    @JoinColumn(name = "artista", nullable = false)
    @NotNull(message = " Un Artista debe estar asociada a un disco")
    private Artista artista;
    @ManyToOne
    @JoinColumn(name = "genero_musical", nullable = false)
    @NotNull(message = " Un genero musical debe estar asociada a un disco")
    private GeneroMusical generoMusical;
}