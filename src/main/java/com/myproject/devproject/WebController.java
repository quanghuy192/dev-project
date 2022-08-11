package com.myproject.devproject;

import com.myproject.devproject.models.User;
import com.myproject.devproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class WebController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/users")
    public String registerUsers(@RequestBody User user) {
        userService.resolveUser(user);
        return "index";
    }

    @GetMapping("/users")
    public String getUsers() {
        userService.findAll();
        return "index";
    }

    @GetMapping("/user/{username}")
    public String getUser(@PathVariable String username) {
        userService.findBy(username);
        return "index";
    }
}
