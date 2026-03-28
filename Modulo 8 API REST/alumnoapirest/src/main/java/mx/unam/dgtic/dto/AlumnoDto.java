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

    @NotBlank(message = "No puede estar en blanco el apellido")
    @Min(message = "El apellido debe ser de almenos 5 caracteres", value = 5)
    private String apellido;

    @Email
    @Size(min = 5 , message = "El correo debe tener al menos 5 caracteres")
    private String correo;

    @Positive(message = "La calificacion debe ser positiva")
    @Max(value = 10 , message = "La calificacion no puede ser mayor a 10")
    @Min(value = 10 , message = "La calificacion no puede ser menor a 0")
    private Double promedio;

}
