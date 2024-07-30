package com.myproject.devproject.application.usecases;

import com.myproject.devproject.application.entities.User;
import com.myproject.devproject.datasources.mysql.UserRepositoryMysql;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class UserUseCase {

    @Autowired
    UserRepositoryMysql userRepository;

    @SneakyThrows
    public User findBy(String username){
        return userRepository.findUserByUsername(username);
    }

    public List<User> findAll() throws Exception {
        final List<User> users = userRepository.findAll();
        if(CollectionUtils.isEmpty(users)){
            throw new Exception("User empty");
        }
        return users;
    }

    public User resolveUser(User user){
        return userRepository.save(user);
    }
}
