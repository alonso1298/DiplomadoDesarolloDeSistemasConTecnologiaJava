package dgtic.core.repository;

import dgtic.core.modelo.Estudiante;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("baseDeDatosDaoExtra")
@Primary
public class BaseDeDatosDaoExtraImpl implements IBaseDeDatosDao{
    @Override
    public List<Estudiante> getEstudiantes(String carrera) {
        return BaseDeDatos.carreras.get(carrera);
    }

    @Override
    public Estudiante getEstudiante(String carrera, String matricula) {

        return BaseDeDatos.carreras.get(carrera)
                .stream().filter(
                        estudiante ->estudiante.getMatricula().equals(matricula) )
                .findFirst().orElse(null);
    }
}
