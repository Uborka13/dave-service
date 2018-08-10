package hu.ubi.soft.database.personallists.repository;

import hu.ubi.soft.database.beers.dtos.Beers;
import hu.ubi.soft.database.personallists.dto.PersonalListItemRelations;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonalListItemRelationsRepository extends CrudRepository<PersonalListItemRelations, Long> {

    PersonalListItemRelations findByRelationId(Long relationId);

    List<PersonalListItemRelations> findByPersonalListId(Long personalListId);

    List<Beers> findBeersByPersonalListId(Long personalListId);

    PersonalListItemRelations findByBeerItemId(Long beerItemId);
}
