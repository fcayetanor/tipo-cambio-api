package pe.com.abc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pe.com.abc.dto.ExchangeRate;
import pe.com.abc.dto.ExchangeRateResponse;
import pe.com.abc.proxy.ExchangeRateProxy;

@Mapper
public interface ExchangeRateMapper {

    ExchangeRateMapper INSTANCE = Mappers.getMapper(ExchangeRateMapper.class);

    ExchangeRate ExchangeRateProxyToExchangeRate(ExchangeRateProxy exchangeRateProxy);

    @Mapping(source = "exchangeRate.fecha", target = "fecha")
    @Mapping(source = "exchangeRate.sunat", target = "sunat")
    @Mapping(source = "exchangeRate.compra", target = "compra")
    @Mapping(source = "exchangeRate.venta", target = "venta")
    @Mapping(source = "dni", target = "dni")
    @Mapping(source = "consultasRealizadas", target = "consultasRealizadas")
    ExchangeRateResponse toExchangeRateResponse(ExchangeRate exchangeRate, String dni, Long consultasRealizadas);

}
