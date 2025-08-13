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
public class ExchangeRate {
    //private String dni;
    private String fecha;
    private BigDecimal sunat;
    private BigDecimal compra;
    private BigDecimal venta;
}
