package com.myproject.devproject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.myproject.devproject.models.User;
import com.myproject.devproject.repositories.MovieRepository;
import com.myproject.devproject.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = DevProjectApplication.class)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
class DevProjectApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void givenUser_whenRegister_thenStatus200()
            throws Exception {

        final User user = new User();
        user.setUsername("name1");
        user.setPassword("pass123@");

        final User userExist = userRepository.findUserByUsername(user.getUsername());
        if (Objects.nonNull(userExist)) {
            userRepository.delete(userExist);
        }

        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(user);

        mvc.perform(post("/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .flashAttr("user", user)
                        .content(requestJson))
                .andExpect(status().isOk());

        final User userSaved = userRepository.findUserByUsername(user.getUsername());
        assertThat(userSaved).isNotNull();
    }

    @Test
    public void givenUser_whenGetAll_thenStatus200()
            throws Exception {

        final User user1 = new User();
        user1.setUsername("name1");
        user1.setPassword("pass123@1");

        final User user2 = new User();
        user2.setUsername("name2");
        user2.setPassword("pass123@2");

        final User userExist1 = userRepository.findUserByUsername(user1.getUsername());
        final User userExist2 = userRepository.findUserByUsername(user1.getUsername());
        if (Objects.nonNull(userExist1)) {
            userRepository.delete(userExist1);
        }
        if (Objects.nonNull(userExist2)) {
            userRepository.delete(userExist2);
        }

        userRepository.saveAll(Arrays.asList(user1, user2));
        mvc.perform(get("/users")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void givenUser_whenUserEmpty_thenStatus400()
            throws Exception {

        userRepository.deleteAll();
        movieRepository.deleteAll();

        mvc.perform(get("/users")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }
}
