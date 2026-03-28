package mx.unam.dgtic.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "alumnos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    @Size(min = 5, message = "No debe ser menor de 5")
    private String nombre;
    @Column(nullable = false, length = 150)
    private String apellido;
    @Column(nullable = false, length = 200)
    @Email
    private String correo;

    // Aquí haremos una OneToMany hacia calificaciones
    @OneToMany(mappedBy = "alumno",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Calificacion> calificaciones;

    public Double calcularPromedio() {
        if (this.calificaciones == null) {
            return 0.0;
        } else {
            return this.calificaciones.stream()
                    .mapToDouble(Calificacion::getNota)
                    .average()
                    .orElse(0.0);
        }
    }
}
