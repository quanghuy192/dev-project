package usecases.user;

import entities.User;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import repositories.IUserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserUseCase {

    @Autowired
    IUserRepository userRepository;

    @SneakyThrows
    public Optional<User> findBy(String username){
        return userRepository.findByUsername(username);
    }

    public List<User> findAll() throws Exception {
        final List<User> users = userRepository.getAll();
        if(CollectionUtils.isEmpty(users)){
            throw new Exception("User empty");
        }
        return users;
    }

    public Optional<User> storeUser(User user){
        return userRepository.save(user);
    }
}
