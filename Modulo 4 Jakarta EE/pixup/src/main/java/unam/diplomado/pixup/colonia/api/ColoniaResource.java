package unam.diplomado.pixup.colonia.api;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import unam.diplomado.pixup.colonia.domain.Colonia;
import unam.diplomado.pixup.colonia.repository.IColoniaReposritory;

import java.util.Collection;
import java.util.Optional;

@RequestScoped // Por cada peticion se creara un nuevo objeto
public class ColoniaResource implements IColoniaApi{

    @Inject
    private IColoniaReposritory coloniaReposritory;

    @Override
    public Colonia getColoniaById(Integer id) {
        Optional<Colonia> colonia = coloniaReposritory.findById(id);
        return colonia.orElse(null);
        /*
        if (colonia.isPresent()) {
            return colonia.get();
        }
        return null;
         */
    }

    @Override
    public Collection<Colonia> getColoniasByCp(String cp) {
        return coloniaReposritory.finByCp(cp);
    }
}
