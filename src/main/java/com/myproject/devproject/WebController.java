package com.myproject.devproject;

import com.myproject.devproject.models.Movie;
import com.myproject.devproject.models.User;
import com.myproject.devproject.services.MovieService;
import com.myproject.devproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class WebController {

    @Autowired
    UserService userService;

    @Autowired
    MovieService movieService;

    @PostMapping("/shared")
    public String shared() {
        return "shared";
    }

    @GetMapping("/")
    public String index(Model model) {
        final List<Movie> movies = movieService.findAll();

        model.addAttribute("movies", movies);
        model.addAttribute("user", new User());
        return "index";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            //errors processing
        }
        model.addAttribute("user", user);

        // user exist
        if(userService.findBy(user.getUsername()) != null){
            return "logout";
        }

        userService.resolveUser(user);
        return "logout";
    }

    @GetMapping("/users")
    public String getUsers() {
        userService.findAll();
        return "index";
    }

    @PostMapping("/user/{username}")
    public String login(@PathVariable String username) {
        userService.findBy(username);
        return "index";
    }
}
