package pe.com.abc.proxy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExchangeRateProxy {
    //representa el objeto que devuelve el api externa
    //clase que va a representar lo que devuelve la api externa
    //private String dni;
    private String fecha;
    private BigDecimal sunat;
    private BigDecimal compra;
    private BigDecimal venta;
}
