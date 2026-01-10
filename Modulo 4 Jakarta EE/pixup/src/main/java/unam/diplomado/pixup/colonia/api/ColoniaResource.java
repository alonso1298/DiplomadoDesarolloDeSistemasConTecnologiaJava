package unam.diplomado.pixup.colonia.api;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import unam.diplomado.pixup.colonia.api.dto.ColoniaDTO;
import unam.diplomado.pixup.colonia.api.dto.ColoniaMapper;
import unam.diplomado.pixup.colonia.domain.Colonia;
import unam.diplomado.pixup.repository.IColoniaReposritory;
import unam.diplomado.pixup.colonia.service.IColoniaService;

import java.util.ArrayList;
import java.util.Collection;

@RequestScoped // Por cada peticion se creara un nuevo objeto
public class ColoniaResource implements IColoniaApi{

    @Inject
    private IColoniaReposritory coloniaReposritory;
    @Inject
    private IColoniaService coloniaService;
    @Inject
    private ColoniaMapper coloniaMapper;

    @Override
    public Colonia getColoniaById(Integer id) {
        return coloniaService.obtenerColoniaPorId(id);
    }

    @Override
    public Collection<ColoniaDTO> getColoniasByCp(String cp) {
        Collection<Colonia> colonias = coloniaReposritory.finByCp(cp);
        Collection<ColoniaDTO> coloniasDTO = new ArrayList<>();
        for (Colonia colonia: colonias){
            coloniasDTO.add(coloniaMapper.toDto(colonia));
        }
        return coloniasDTO;
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
