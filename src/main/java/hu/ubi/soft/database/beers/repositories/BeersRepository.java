package hu.ubi.soft.database.beers.repositories;

import hu.ubi.soft.database.beers.dtos.Beers;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface BeersRepository extends CrudRepository<Beers, Long> {

    List<Beers> findByBeerIdIn(Collection<Long> ids);
}
