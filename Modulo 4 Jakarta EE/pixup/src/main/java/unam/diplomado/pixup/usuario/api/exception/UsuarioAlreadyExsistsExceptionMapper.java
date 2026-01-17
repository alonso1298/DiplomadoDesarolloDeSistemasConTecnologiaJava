package unam.diplomado.pixup.usuario.api.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import unam.diplomado.pixup.usuario.api.dto.ErrorResponseDTO;
import unam.diplomado.pixup.usuario.domain.UsuarioAlreadyExistsException;

public class UsuarioAlreadyExsistsExceptionMapper implements ExceptionMapper<UsuarioAlreadyExistsException> {

    @Override
    public Response toResponse(UsuarioAlreadyExistsException e) {
        return Response.status(Response.Status.CONFLICT)
                .entity(new ErrorResponseDTO(
                        Response.Status.CONFLICT.getStatusCode(),
                        "BUSINESS_RULE",
                        e.getMessage()))
                .build();
    }
}
