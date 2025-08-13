package pe.com.abc.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import pe.com.abc.dto.ExchangeRate;

import java.time.LocalDate;

@Path("/tipo-cambio")
public interface ExchangeRateResource {

    @GET
    ExchangeRate getExchangeRateToday();

}
