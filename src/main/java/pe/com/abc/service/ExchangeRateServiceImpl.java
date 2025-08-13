package pe.com.abc.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import pe.com.abc.dto.ExchangeRate;
import pe.com.abc.dto.ExchangeRateRequest;
import pe.com.abc.dto.ExchangeRateResponse;
import pe.com.abc.entity.ExchangeRateQuery;
import pe.com.abc.exception.ExchangeRateLimitExceededException;
import pe.com.abc.repository.ExchangeRateQueryRepository;
import pe.com.abc.repository.ExchangeRateRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ApplicationScoped
@AllArgsConstructor
public class ExchangeRateServiceImpl implements ExchangeRateService{

    private static final int DAILY_LIMIT = 10;

    //private ExchangeRateRepository exchangeRateRepository;
    private final ExchangeRateRepository exchangeRateRepository;
    private final ExchangeRateQueryRepository queryRepository;

    //@Override
    //public ExchangeRate getExchangeRateToday() {
    //    LocalDate hoy = LocalDate.now();
    //    String fechaFormateada = hoy.format(DateTimeFormatter.ISO_LOCAL_DATE);
    //    return exchangeRateRepository.getExchangeRateToday(fechaFormateada);
    //}

    @Override
    @Transactional
    public ExchangeRateResponse getExchangeRateToday(ExchangeRateRequest request) {
        String dni = request.getDni();
        LocalDate today = LocalDate.now();

        // Validar límite diario
        long todayQueries = queryRepository.countQueriesByDniAndDate(dni, today);
        if (todayQueries >= DAILY_LIMIT) {
            throw new ExchangeRateLimitExceededException(dni, todayQueries);
        }

        // Obtener tipo de cambio
        String fechaFormateada = today.format(DateTimeFormatter.ISO_LOCAL_DATE);
        ExchangeRate exchangeRate = exchangeRateRepository.getExchangeRateToday(fechaFormateada);

        // Registrar consulta
        ExchangeRateQuery query = new ExchangeRateQuery(dni, today, LocalDateTime.now());
        queryRepository.saveQuery(query);

        // Contar consultas totales después de registrar
        long totalQueries = queryRepository.countTotalQueriesByDni(dni);

        return new ExchangeRateResponse(
                exchangeRate.getFecha(),
                exchangeRate.getSunat(),
                exchangeRate.getCompra(),
                exchangeRate.getVenta(),
                dni,
                totalQueries
        );
    }

    @Override
    public Long getQueryCountByDni(String dni) {
        return queryRepository.countTotalQueriesByDni(dni);
    }

}
