package pe.com.abc.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "exchange_rate_queries")
public class ExchangeRateQuery extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false)
    public String dni;

    @Column(nullable = false)
    public LocalDate queryDate;

    @Column(nullable = false)
    public LocalDateTime queryDateTime;

    public ExchangeRateQuery() {}

    public ExchangeRateQuery(String dni, LocalDate queryDate, LocalDateTime queryDateTime) {
        this.dni = dni;
        this.queryDate = queryDate;
        this.queryDateTime = queryDateTime;
    }

    // Método para contar consultas por DNI y fecha
    public static long countByDniAndDate(String dni, LocalDate date) {
        return count("dni = ?1 and queryDate = ?2", dni, date);
    }

    // Método para obtener todas las consultas por DNI
    public static long countByDni(String dni) {
        return count("dni = ?1", dni);
    }

}
