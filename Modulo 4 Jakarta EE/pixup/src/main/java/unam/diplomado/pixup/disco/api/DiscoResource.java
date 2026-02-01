package unam.diplomado.pixup.disco.api;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.core.Response;
import unam.diplomado.pixup.disco.domain.Disco;
import unam.diplomado.pixup.disco.service.IDiscoService;

@RequestScoped
public class DiscoResource implements IDiscoApi {

    @Inject
    private IDiscoService discoService;

    @Inject
    private DiscoMapper discoMapper;

    @Override
    public Response altaDisco(@NotNull @Valid DiscoRequestDTO disco) {

        var discoEntity = discoMapper.toDisco(disco);
        var discoGuardado = discoService.registrarDisco(discoEntity);
        var response = discoMapper.toDto(discoGuardado);

        return Response.status(Response.Status.CREATED)
                .entity(response)
                .build();
    }

    @Override
    public Response altaDisco(Disco disco) {
        return null;
    }
}
