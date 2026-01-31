package dgtic.core.servicio;

import dgtic.core.repository.IBaseDeDatosDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ServicioDao {

    @Autowired
    private IBaseDeDatosDao baseDeDatosDao;

    public String archivoCSV(String carrera){
        return baseDeDatosDao.getEstudiantes(carrera).stream()
                .map(alm->alm.getMatricula()+";"+
                        (alm.getMaterias().stream()
                                .map(mat->(mat.getNombre()+";"+mat.getCreditos()))
                                .collect(Collectors.joining(";")))+";"+alm.getNombre())
                .collect(Collectors.joining("\n"));
    }
}
