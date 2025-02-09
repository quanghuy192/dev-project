package repositories;

import core.IRepository;
import entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository extends IRepository<User> {
    Optional<User> findByUsername(String username);
    Optional<User> save(User user);
    void saveAll(List<User> users);
    void deleteAll();
}
