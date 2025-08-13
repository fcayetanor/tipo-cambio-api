package pe.com.abc.repository;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import pe.com.abc.dto.ExchangeRate;
import pe.com.abc.mapper.ExchangeRateMapper;
import pe.com.abc.proxy.ApiProxy;
import pe.com.abc.proxy.ExchangeRateProxy;

@ApplicationScoped
public class ExchangeRateRepositoryImpl implements ExchangeRateRepository{

    private final ApiProxy apiProxy;

    public ExchangeRateRepositoryImpl(@RestClient ApiProxy apiProxy){
        this.apiProxy = apiProxy;
    }

    @Override
    public ExchangeRate getExchangeRateToday(String fechaFormateada) {
        ExchangeRateProxy proxyExchangeRate = apiProxy.getExchangeRateToday(fechaFormateada);
        return ExchangeRateMapper.INSTANCE.ExchangeRateProxyToExchangeRate(proxyExchangeRate);
    }

}
