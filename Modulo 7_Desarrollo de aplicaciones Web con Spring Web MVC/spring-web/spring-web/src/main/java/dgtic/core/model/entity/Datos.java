package dgtic.core.model.entity;

import java.util.List;

public class Datos {
    private List<Pais> paises = List.of(
            new Pais(1L, "México"),
            new Pais(2L, "España"),
            new Pais(3L, "Argentina")
    );
    private List<Ciudad> ciudades = List.of(
            new Ciudad(1L, "CDMX", 1L),
            new Ciudad(2L, "Guadalajara", 1L),
            new Ciudad(3L, "Madrid", 2L),
            new Ciudad(4L, "Barcelona", 2L),
            new Ciudad(5L, "Buenos Aires", 3L)
    );

    public List<Pais> getPaises() {
        return paises;
    }

    public void setPaises(List<Pais> paises) {
        this.paises = paises;
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }
}
