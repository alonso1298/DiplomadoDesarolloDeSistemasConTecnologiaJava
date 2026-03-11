package dgtic.core.model.dto;

import dgtic.core.validation.NoEspacioNoVacio;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    @NoEspacioNoVacio
    private String nombre;
    @Email(message = "Correo no valido")
    @Pattern(regexp = ".*dgtic")
    private String correo;
    @NotBlank(message = "El código postal es obligatorio")
    @Pattern(regexp = "\\d{5}", message = "El CP debe tener 5 dígitos")
    private String cp;
    @NotBlank(message = "El teléfono es obligatorio")
    @Pattern(regexp = "55[0-9]{8}", message = "El teléfono debe iniciar con 55 y tener 10 dígitos")
    private String telefono;
    @NotNull
    @Range(min=18,max=60,message="No tienes la edad")
    private Integer edad;

}
