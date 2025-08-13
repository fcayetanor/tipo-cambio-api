package pe.com.abc.resource;

import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import pe.com.abc.dto.ExchangeRateRequest;

@Path("/tipo-cambio")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface ExchangeRateResource {

    @POST
    Response getExchangeRateToday(@Valid ExchangeRateRequest request);

    @GET
    @Path("/consultas/{dni}")
    Response getQueryCount(@PathParam("dni") String dni);

}
