package dgtic.core.model.entity;

import dgtic.core.validation.NoEspacioNoVacio;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "usuario")
@Table(name = "usuario")
public class UsuarioBd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_user;

    @NoEspacioNoVacio
    private String nombre;

    @Email(message = "Correo no valido")
    @Pattern(regexp = ".*dgtic",message = "El correo no es institucional")
    @Column(unique = true)
    private String correo;

    @NotNull
    @Range(min=18,max=60,message="No tienes la edad")
    private Integer edad;
}
