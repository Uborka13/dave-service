package hu.ubi.soft.database.beers.repositories;

import hu.ubi.soft.database.beers.dtos.BeerTypes;
import org.springframework.data.repository.CrudRepository;

public interface BeerTypesRepository extends CrudRepository<BeerTypes, Long> {
}
