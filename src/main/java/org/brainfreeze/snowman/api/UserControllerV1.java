package org.brainfreeze.snowman.api;

import org.brainfreeze.snowman.mapper.UserMapper;
import org.brainfreeze.snowman.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserControllerV1 {

    private UserMapper mapper;

    public UserControllerV1(UserMapper mapper) {
        this.mapper = mapper;
    }

    @GetMapping("/all")
    public List<User> getAll() {
        List<User> users = mapper.findAll();
        return users;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable(value = "id") Long id) {
        return mapper.findById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody User user) {
        mapper.insert(user);
    }

    @PostMapping("/{id}")
    public void update(@PathVariable(value = "id") Long id, @RequestBody User user) {
        user.setId(id);
        mapper.update(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        mapper.delete(id);
    }
}
