package unam.diplomado.pixup.colonia.api;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import unam.diplomado.pixup.colonia.domain.Colonia;
import unam.diplomado.pixup.colonia.repository.IColoniaReposritory;
import unam.diplomado.pixup.colonia.service.ColoniaServiceImpl;

import java.util.Collection;
import java.util.Optional;

@RequestScoped // Por cada peticion se creara un nuevo objeto
public class ColoniaResource implements IColoniaApi{

    @Inject
    private IColoniaReposritory coloniaReposritory;
    @Inject
    private ColoniaServiceImpl coloniaService;

    @Override
    public Response getColoniaById(Integer id) {
        Optional<Colonia> colonia = coloniaReposritory.findById(id);
        if(colonia.isPresent()){
            return Response
                    .status(Response.Status.OK)
                    .entity(colonia.get())
                    .build();
        }
        return Response
                .status(Response.Status.NOT_FOUND)
                .entity(null)
                .build();
    }

    @Override
    public Collection<Colonia> getColoniasByCp(String cp) {
        return coloniaReposritory.finByCp(cp);
    }
}
