package unam.diplomado.pixup.usuario.api.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import unam.diplomado.pixup.usuario.api.dto.ErrorResponseDTO;
import unam.diplomado.pixup.usuario.domain.TipoDomicilioNotFoudException;

public class TipoDomicilioNotFoundExceptionMapper implements ExceptionMapper<TipoDomicilioNotFoudException> {
    @Override
    public Response toResponse(TipoDomicilioNotFoudException e) {
        return Response.status(Response.Status.PRECONDITION_REQUIRED)
                .entity(new ErrorResponseDTO(
                        Response.Status.PRECONDITION_REQUIRED.getStatusCode(),
                        "DATA_INCONSISTENCY",
                        e.getMessage()))
                .build();
    }
}
