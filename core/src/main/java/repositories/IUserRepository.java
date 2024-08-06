package repositories;

import core.IRepository;
import entities.User;

public interface IUserRepository extends IRepository {
    User findByUsername(String username);
}
