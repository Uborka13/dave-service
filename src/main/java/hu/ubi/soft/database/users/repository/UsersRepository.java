package hu.ubi.soft.database.users.repository;

import hu.ubi.soft.database.users.dto.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<Users, Long> {

    Users findByUserId(Long userId);

    Users findByUserName(String userName);
}
