package com.myproject.devproject;

import com.myproject.devproject.models.User;
import com.myproject.devproject.services.UserService;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserUseCaseTest {

    @Autowired
    private UserService userService;

    @Test
    void savedUserHasRegistrationUsername() {
        final User user1 = new User();
        user1.setUsername("name1");
        user1.setPassword("pass123@1");

        User savedUser = userService.resolveUser(user1);
        assertThat(savedUser.getId()).isNotNull();
    }

}
