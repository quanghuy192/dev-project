package usecases;

import entities.User;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import repositories.IUserRepository;

import java.util.List;

@Service
public class UserUseCase {

    @Autowired
    IUserRepository userRepository;

    @SneakyThrows
    public User findBy(String username){
        return userRepository.findByUsername(username);
    }

    public List<User> findAll() throws Exception {
        final List<User> users = userRepository.getAll();
        if(CollectionUtils.isEmpty(users)){
            throw new Exception("User empty");
        }
        return users;
    }

    public User storeUser(User user){
        return userRepository.store(user);
    }
}
