package com.myproject.devproject.datasources.mysql;

import com.myproject.devproject.application.entities.User;
import com.myproject.devproject.application.repositories.IUserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

@Repository
public interface UserRepositoryMysql extends IUserRepository, JpaRepository<User, Long> {


    // JPA method
    User findUserByUsername(String username);

    // Override from Repository
    @Override
    default User findOne(Long id) {
        return findById(id)
                .orElseThrow(() -> new AssertionError(String.format("User with id %d not found", id)));
    }

    @Override
    default List<User> getALl() {
        return findAll();
    }

    // Override from MovieRepository
    @Override
    default User findByUsername(String username){
        final User user = StringUtils.hasLength(username) ? findUserByUsername(username) : null;
        if(Objects.nonNull(user)){
            return user;
        } else {
            throw new AssertionError(String.format("User with username %s not found", username));
        }
    }
}
