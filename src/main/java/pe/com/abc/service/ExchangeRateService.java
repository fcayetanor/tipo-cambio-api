package pe.com.abc.service;

import pe.com.abc.dto.ExchangeRate;
import pe.com.abc.dto.ExchangeRateRequest;
import pe.com.abc.dto.ExchangeRateResponse;

public interface ExchangeRateService {

    //ExchangeRate getExchangeRateToday();
    ExchangeRateResponse getExchangeRateToday(ExchangeRateRequest request);
    Long getQueryCountByDni(String dni);

}
