package pe.com.abc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pe.com.abc.dto.ExchangeRate;
import pe.com.abc.proxy.ExchangeRateProxy;

@Mapper
public interface ExchangeRateMapper {

    ExchangeRateMapper INSTANCE = Mappers.getMapper(ExchangeRateMapper.class);

    ExchangeRate ExchangeRateProxyToExchangeRate(ExchangeRateProxy exchangeRateProxy);

}
