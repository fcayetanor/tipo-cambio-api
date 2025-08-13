package pe.com.abc.proxy;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

//representa la solicitud a la api externea
@RegisterRestClient(configKey = "exchange-rate-api") //sirve para los properties, alias del api
@Path("/tipo-cambio")
@Produces(MediaType.APPLICATION_JSON)
public interface ApiProxy {

    @GET
    @Path("/{fecha}.json")
    ExchangeRateProxy getExchangeRateToday(@PathParam("fecha") String fecha);
}


