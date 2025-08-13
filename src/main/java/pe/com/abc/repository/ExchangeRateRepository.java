package pe.com.abc.repository;

import pe.com.abc.dto.ExchangeRate;

public interface ExchangeRateRepository {

    ExchangeRate getExchangeRateToday(String fechaFormateada);

}
