package com.myproject.devproject;

import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;
import usecases.UserUseCase;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
public class UserUseCaseTest {

    @InjectMocks
    UserUseCase userService;

    @Mock
    UserRepositoryMysql userRepository;

    @Test
    public void whenSavedUser_shouldReturnSavedUser() {
        final User user1 = new User();
        user1.setUsername("name1");
        user1.setPassword("pass123@1");
        user1.setId(1L);

        when(userRepository.save(any())).thenReturn(user1);

        User savedUser = userService.resolveUser(user1);
        assertThat(savedUser.getId()).isNotNull();
        verify(userRepository).save(any());
    }

    @Test
    @SneakyThrows
    public void whenGetAllUser_shouldReturnListUser() {
        final User user1 = new User();
        user1.setUsername("name1");
        user1.setPassword("pass123@1");
        user1.setId(1L);

        final User user2 = new User();
        user1.setUsername("name2");
        user1.setPassword("pass123@2");
        user1.setId(2L);

        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));

        List<User> users = userService.findAll();
        assertThat(users.size()).isEqualTo(2);
        verify(userRepository).findAll();
    }

    @Test
    @SneakyThrows
    public void whenFindUserByUsername_shouldReturnUser() {
        final User user1 = new User();
        user1.setUsername("name1");
        user1.setPassword("pass123@1");
        user1.setId(1L);

        when(userRepository.findUserByUsername(any())).thenReturn(user1);

        User users = userService.findBy(user1.getUsername());
        assertThat(users.getUsername()).isEqualTo(user1.getUsername());
        assertThat(users.getPassword()).isEqualTo(user1.getPassword());
        verify(userRepository).findUserByUsername(any());
    }
}
