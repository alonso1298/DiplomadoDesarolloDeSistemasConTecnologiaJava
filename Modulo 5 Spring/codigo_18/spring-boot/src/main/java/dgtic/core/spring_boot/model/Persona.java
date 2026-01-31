package dgtic.core.spring_boot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Genera getters, setters y toString
@Builder // Crea el patron builder o sea ya no se ocuparan los metodos set
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
    private String nombre;
    private int edad;

}
