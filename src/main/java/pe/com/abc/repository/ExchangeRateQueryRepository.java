package pe.com.abc.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import pe.com.abc.entity.ExchangeRateQuery;

import java.time.LocalDate;

@ApplicationScoped
public class ExchangeRateQueryRepository implements PanacheRepository<ExchangeRateQuery> {

    public long countQueriesByDniAndDate(String dni, LocalDate date) {
        return ExchangeRateQuery.countByDniAndDate(dni, date);
    }

    public long countTotalQueriesByDni(String dni) {
        return ExchangeRateQuery.countByDni(dni);
    }

    public void saveQuery(ExchangeRateQuery query) {
        query.persist();
    }

}
