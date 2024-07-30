package com.myproject.devproject.application.repositories;

import com.myproject.devproject.application.core.IRepository;
import com.myproject.devproject.application.entities.User;

public interface IUserRepository extends IRepository {
    User findByUsername(String Username);
}
