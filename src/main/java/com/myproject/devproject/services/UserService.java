package com.myproject.devproject.services;

import com.myproject.devproject.models.User;
import com.myproject.devproject.repositories.UserRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @SneakyThrows
    public User findBy(String username){
        return userRepository.findUserByUsername(username);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User resolveUser(User user){
        return userRepository.save(user);
    }
}
