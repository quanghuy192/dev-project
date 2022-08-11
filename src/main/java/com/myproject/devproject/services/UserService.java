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
        User user = userRepository.findUserByUsername(username);
        if(user == null){
            throw new Exception("User not found");
        }
        return user;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User resolveUser(User user){
        return userRepository.save(user);
    }
}
