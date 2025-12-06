package unam.diplomado.pixup.usuario.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tipo_domicilio")
public class TipoDomicilio implements Serializable { // Transfoma la entidad a un conjunto de bytes para que se pueda transmitir en red

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descripcion;


}
