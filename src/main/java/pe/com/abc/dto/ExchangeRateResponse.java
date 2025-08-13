package pe.com.abc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExchangeRateResponse {
    private String fecha;
    private BigDecimal sunat;
    private BigDecimal compra;
    private BigDecimal venta;
    private String dni;
    private Long consultasRealizadas;
}
