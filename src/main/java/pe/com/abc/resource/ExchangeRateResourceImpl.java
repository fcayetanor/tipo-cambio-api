package pe.com.abc.resource;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;
import pe.com.abc.dto.ExchangeRate;
import pe.com.abc.service.ExchangeRateService;

@AllArgsConstructor
@ApplicationScoped
public class ExchangeRateResourceImpl implements ExchangeRateResource{

    private ExchangeRateService exchangeRateService;

    @Override
    public ExchangeRate getExchangeRateToday() {
        return exchangeRateService.getExchangeRateToday();
    }
}
