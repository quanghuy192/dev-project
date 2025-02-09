package usecases.user;

import dto.UserDTO;
import entities.User;
import lombok.val;
import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.IUserRepository;

import java.util.Optional;

@Service
public class CreateUserUseCase {
    @Autowired
    IUserRepository userRepository;

    public Optional<User> create(UserDTO userDto) {
        val user = UserMapper.INSTANCE.fromDTO(userDto);
        return userRepository.save(user);
    }
}
