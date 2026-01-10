package unam.diplomado.pixup.colonia.api;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import unam.diplomado.pixup.colonia.domain.Colonia;
import unam.diplomado.pixup.colonia.domain.ColoniaAlreradyExistsException;
import unam.diplomado.pixup.colonia.domain.ColoniaNotFoudException;
import unam.diplomado.pixup.repository.IColoniaReposritory;
import unam.diplomado.pixup.colonia.service.IColoniaService;

import java.util.Collection;

@RequestScoped // Por cada peticion se creara un nuevo objeto
public class ColoniaResource implements IColoniaApi{

    @Inject
    private IColoniaReposritory coloniaReposritory;
    @Inject
    private IColoniaService coloniaService;

    @Override
    public Colonia getColoniaById(Integer id) {
        return coloniaService.obtenerColoniaPorId(id);
    }

    @Override
    public Collection<Colonia> getColoniasByCp(String cp) {
        return coloniaReposritory.finByCp(cp);
    }

    @Override
    public void deleteColonia(Integer id) {

    }

    @Override
    public Response createColonia(Colonia colonia) {
        Colonia coloniaCreada = coloniaService.crearColonia(colonia);
        return Response
                .status(Response.Status.CREATED)
                .entity(coloniaCreada)
                .build();
    }

    @Override
    public Colonia updateColonia(Integer id, Colonia colonia) {
        colonia.setId(id);
        return coloniaService.actualizarColonia(colonia);
    }
}
