package mx.unam.dgtic.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "calificaciones")
@Data
public class CalificacionDto {

    private Long id;
    @NotNull
    @NotBlank
    private String curso;
    private Double nota;
    private Long idAlumno;
}
