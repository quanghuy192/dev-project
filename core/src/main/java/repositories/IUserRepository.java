package repositories;

import core.IRepository;
import entities.User;

import java.util.List;

public interface IUserRepository extends IRepository {
    User findByUsername(String username);
    User store(User user);
    boolean storeAll(List<User> users);
    boolean deleteAll();
}
