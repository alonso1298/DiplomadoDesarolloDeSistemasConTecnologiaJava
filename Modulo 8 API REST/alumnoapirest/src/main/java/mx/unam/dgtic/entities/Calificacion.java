package mx.unam.dgtic.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "calificaciones")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "alumno")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Calificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String curso;
    @Column(nullable = false)
    private Double nota;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "alumno_id", nullable = false)
    @JsonBackReference
    private Alumno alumno;
}
