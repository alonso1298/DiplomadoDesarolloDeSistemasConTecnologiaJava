package mx.unam.dgtic.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
public class AlumnoDto {

    private Long id;

    @NotNull(message = "El nombre no puede ser nulo")
    @Size(min = 5, max = 100, message = "El nombre no cumple con la longitud")
    @NotBlank(message = "No puede ser cadena vacía")
    @Min(value = 5)
    private String nombre;

    private String apellido;

    private String correo;

    private Double promedio;

}
