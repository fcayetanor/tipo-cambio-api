package pe.com.abc.resource;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.validation.Valid;
import jakarta.ws.rs.core.Response;
import lombok.AllArgsConstructor;
import pe.com.abc.dto.ErrorResponse;
import pe.com.abc.dto.ExchangeRate;
import pe.com.abc.dto.ExchangeRateRequest;
import pe.com.abc.dto.ExchangeRateResponse;
import pe.com.abc.exception.ExchangeRateLimitExceededException;
import pe.com.abc.service.ExchangeRateService;

import java.util.Map;

@ApplicationScoped
public class ExchangeRateResourceImpl implements ExchangeRateResource{

    private final ExchangeRateService exchangeRateService;

    public ExchangeRateResourceImpl(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @Override
    public Response getExchangeRateToday(@Valid ExchangeRateRequest request) {
        try {
            ExchangeRateResponse response = exchangeRateService.getExchangeRateToday(request);
            return Response.ok(response).build();
        } catch (ExchangeRateLimitExceededException e) {
            ErrorResponse errorResponse = new ErrorResponse(
                    "LIMIT_EXCEEDED",
                    e.getMessage(),
                    e.getDni(),
                    e.getCurrentQueries()
            );
            return Response.status(Response.Status.TOO_MANY_REQUESTS)
                    .entity(errorResponse)
                    .build();
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse(
                    "INTERNAL_ERROR",
                    "Error interno del servidor: " + e.getMessage(),
                    request.getDni(),
                    null
            );
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(errorResponse)
                    .build();
        }
    }

    @Override
    public Response getQueryCount(String dni) {
        try {
            if (dni == null || !dni.matches("\\d{8}")) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity(Map.of("error", "DNI inválido. Debe tener exactamente 8 dígitos"))
                        .build();
            }

            Long count = exchangeRateService.getQueryCountByDni(dni);
            return Response.ok(Map.of(
                    "dni", dni,
                    "totalConsultas", count
            )).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(Map.of("error", "Error interno del servidor: " + e.getMessage()))
                    .build();
        }
    }

}
