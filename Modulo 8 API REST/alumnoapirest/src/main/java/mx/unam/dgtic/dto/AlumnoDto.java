package mx.unam.dgtic.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
public class AlumnoDto {

    private Long id;

    @NotNull(message = "El nombre no puede ser nulo")
    @Size(min = 5, max = 100, message = "El nombre no cumple con la longitud")
    @NotBlank(message = "No puede ser cadena vacía")
    private String nombre;

    private String apellido;

    private String correo;

}
