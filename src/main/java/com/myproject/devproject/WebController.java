package com.myproject.devproject;

import com.myproject.devproject.models.Movie;
import com.myproject.devproject.models.Notification;
import com.myproject.devproject.models.User;
import com.myproject.devproject.services.MovieService;
import com.myproject.devproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@Controller
public class WebController {

    private final ConcurrentHashMap<String, Object> cacheMap = new ConcurrentHashMap<>();
    @Autowired
    UserService userService;
    @Autowired
    MovieService movieService;
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @RequestMapping(value = "/shared", method = RequestMethod.POST)
    public String shared(Model model) {
        if (cacheMap.containsKey("user")) {
            User user = (User) cacheMap.get("user");
            if (Objects.nonNull(user)) {
                model.addAttribute("user", user);
            }
        }
        return "share";
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

        final List<Movie> movies = movieService.findAll();
        model.addAttribute("user", user);
        model.addAttribute("movies", movies);

        // user exist
        if (userService.findBy(user.getUsername()) != null) {
            cacheMap.putIfAbsent("user", user);
            return "register";
        }

        userService.resolveUser(user);
        cacheMap.putIfAbsent("user", user);
        return "register";
    }

    @GetMapping("/users")
    public ResponseEntity<HttpStatus> getUsers() {
        try {
            userService.findAll();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/user/{username}")
    public String login(@PathVariable String username) {
        User userExist = userService.findBy(username);
        if (Objects.nonNull(userExist)) {
            return "index";
        } else {
            return "error";
        }
    }

    @MessageMapping("/subscribe")
    @SendTo("/all/messages")
    public Notification send(final Notification notification) {
        return notification;
    }
}
