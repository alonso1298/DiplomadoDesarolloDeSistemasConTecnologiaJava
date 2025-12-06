package unam.diplomado.pixup.colonia.domain;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Colonia {

    private Integer id;
    private String nombre;
    private String codigoPostal;

}
