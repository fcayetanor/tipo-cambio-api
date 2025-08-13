package pe.com.abc.exception;

import lombok.Getter;

@Getter
public class ExchangeRateLimitExceededException extends RuntimeException {

    private final String dni;
    private final Long currentQueries;

    public ExchangeRateLimitExceededException(String dni, Long currentQueries) {
        super(String.format("Cliente con DNI %s ha excedido el límite diario de consultas (10). Consultas realizadas hoy: %d", dni, currentQueries));
        this.dni = dni;
        this.currentQueries = currentQueries;
    }

}
