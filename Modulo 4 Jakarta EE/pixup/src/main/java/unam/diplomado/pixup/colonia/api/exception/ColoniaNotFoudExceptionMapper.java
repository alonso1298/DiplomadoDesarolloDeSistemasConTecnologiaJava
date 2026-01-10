package unam.diplomado.pixup.colonia.api.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import unam.diplomado.pixup.colonia.domain.ColoniaNotFoudException;

@Provider // Especifica una clase que tiene que ser gestionada por el contenedor
public class ColoniaNotFoudExceptionMapper implements ExceptionMapper<ColoniaNotFoudException> {

    @Override
    public Response toResponse(ColoniaNotFoudException e) {
        return Response
                .status(Response.Status.NOT_FOUND)
                .entity(e.getMessage())
                .build();
    }
}
