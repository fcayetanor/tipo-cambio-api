package pe.com.abc.service;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;
import pe.com.abc.dto.ExchangeRate;
import pe.com.abc.repository.ExchangeRateRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@ApplicationScoped
@AllArgsConstructor
public class ExchangeRateServiceImpl implements ExchangeRateService{

    private ExchangeRateRepository exchangeRateRepository;

    @Override
    public ExchangeRate getExchangeRateToday() {
        LocalDate hoy = LocalDate.now();
        String fechaFormateada = hoy.format(DateTimeFormatter.ISO_LOCAL_DATE);
        return exchangeRateRepository.getExchangeRateToday(fechaFormateada);
    }
}
