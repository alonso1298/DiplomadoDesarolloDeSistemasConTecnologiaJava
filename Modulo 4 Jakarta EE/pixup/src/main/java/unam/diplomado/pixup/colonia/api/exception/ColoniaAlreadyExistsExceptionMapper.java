package unam.diplomado.pixup.colonia.api.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import unam.diplomado.pixup.colonia.domain.ColoniaAlreradyExistsException;

@Provider // Es como un catch gigante que envuelve todo el projecto gestiona los errores
public class ColoniaAlreadyExistsExceptionMapper implements ExceptionMapper<ColoniaAlreradyExistsException> {

    @Override
    public Response toResponse(ColoniaAlreradyExistsException e) {
        return Response
                .status(Response.Status.CONFLICT)
                .entity(e.getMessage())
                .build();
    }
}
