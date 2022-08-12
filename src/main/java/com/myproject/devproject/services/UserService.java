package com.myproject.devproject.services;

import com.myproject.devproject.models.User;
import com.myproject.devproject.repositories.UserRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @SneakyThrows
    public User findBy(String username){
        return userRepository.findUserByUsername(username);
    }

    @SneakyThrows
    public List<User> findAll(){
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
