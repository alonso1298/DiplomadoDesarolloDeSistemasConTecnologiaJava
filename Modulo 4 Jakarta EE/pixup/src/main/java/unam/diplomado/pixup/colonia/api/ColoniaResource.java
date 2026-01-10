package unam.diplomado.pixup.colonia.api;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import unam.diplomado.pixup.colonia.domain.Colonia;
import unam.diplomado.pixup.colonia.domain.ColoniaAlreradyExistsException;
import unam.diplomado.pixup.colonia.domain.ColoniaNotFoudException;
import unam.diplomado.pixup.repository.IColoniaReposritory;
import unam.diplomado.pixup.colonia.service.ColoniaServiceImpl;

import java.util.Collection;

@RequestScoped // Por cada peticion se creara un nuevo objeto
public class ColoniaResource implements IColoniaApi{

    @Inject
    private IColoniaReposritory coloniaReposritory;
    @Inject
    private ColoniaServiceImpl coloniaService;

    @Override
    public Response getColoniaById(Integer id) {
        try {
            Colonia colonia = coloniaService.obtenerColoniaPorId(id);
            return Response
                    .status(Response.Status.OK)
                    .entity(colonia)
                    .build();
        } catch (ColoniaNotFoudException e) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity(e.getMessage())
                    .build();
        }
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
        try {
            return Response
                    .status(Response.Status.CREATED)
                    .entity(coloniaCreada)
                    .build();
        }catch (Exception e) {
            if (e instanceof ColoniaAlreradyExistsException) {
                return Response
                        .status(Response.Status.CONFLICT)
                        .entity(coloniaCreada)
                        .build();
            }
            return Response
                    .status(Response.Status.PRECONDITION_REQUIRED)
                    .entity(coloniaCreada)
                    .build();
        }

    }

    @Override
    public void updateColonia(Integer id, Colonia colonia) {

    }
}
