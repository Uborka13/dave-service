package hu.ubi.soft.database.personallists.repository;

import hu.ubi.soft.database.personallists.dto.PersonalLists;
import org.springframework.data.repository.CrudRepository;

public interface PersonalListsRepository extends CrudRepository<PersonalLists, Long> {

    PersonalLists findByPersonalListId(Long personalListId);

}
