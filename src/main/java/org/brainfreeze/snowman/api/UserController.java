package org.brainfreeze.snowman.api;

import org.brainfreeze.snowman.mapper.UserMapper;
import org.brainfreeze.snowman.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserMapper mapper;

    public UserController(UserMapper mapper) {
        this.mapper = mapper;
    }

    @GetMapping("/all")
    public List<User> getAll() {
        List<User> users = mapper.findAll();
        return users;
    }

}
