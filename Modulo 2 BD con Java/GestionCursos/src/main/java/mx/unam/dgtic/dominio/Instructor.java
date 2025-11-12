package mx.unam.dgtic.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Instructor {

    private int id;
    private String nombre;
    private String apellidoPaterno;
    private String correoElectronico;
    private Especialidad especialidad;

}
