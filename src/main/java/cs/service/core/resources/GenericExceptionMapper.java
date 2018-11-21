package cs.service.core.resources;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


@Setter
@Getter
@Data
class ErrorDTO {
    private int code;
    private String description;
    private String message;
}

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception ex) {
        Response.StatusType type = getStatusType(ex);

        ErrorDTO error = new ErrorDTO();
        error.setCode(type.getStatusCode());
        error.setDescription(type.getReasonPhrase());
        error.setMessage(ex.getLocalizedMessage());


        return Response.status(error.getCode())
                .entity(error)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

    private Response.StatusType getStatusType(Throwable ex) {
        if (ex instanceof WebApplicationException) {
            return((WebApplicationException)ex).getResponse().getStatusInfo();
        } else {
            return Response.Status.INTERNAL_SERVER_ERROR;
        }
    }
}