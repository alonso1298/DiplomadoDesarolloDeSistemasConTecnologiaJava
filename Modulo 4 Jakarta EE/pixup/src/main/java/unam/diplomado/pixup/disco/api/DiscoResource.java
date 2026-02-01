package unam.diplomado.pixup.disco.api;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import unam.diplomado.pixup.disco.domain.Disco;
import unam.diplomado.pixup.disco.service.IDiscoService;

@RequestScoped
public class DiscoResource implements IDiscoApi{

    @Inject
    private IDiscoService discoService;

    @Inject
    private DiscoMa

    @Override
    public Response altaDisco(Disco disco) {
        return null;
    }
}
