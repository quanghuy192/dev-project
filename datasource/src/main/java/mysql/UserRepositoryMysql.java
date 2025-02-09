package mysql;

import entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import repositories.IUserRepository;

@Repository
public interface UserRepositoryMysql extends IUserRepository, JpaRepository<Long, User> {
    User findUserByUsername(String username);
}
