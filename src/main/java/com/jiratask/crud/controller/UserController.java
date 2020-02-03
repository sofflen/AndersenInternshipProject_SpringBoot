package com.jiratask.crud.controller;

import com.jiratask.crud.dto.UserDTO;
import com.jiratask.crud.model.User;
import com.jiratask.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String homePage() {
        return ("<h1>Welcome to <p><a href=\"/users\">User list</a></p></h1>");
    }

    @GetMapping("/user")
    public String user() {
        return ("<h1>Welcome user</h1>");
    }

    @GetMapping("/admin")
    public String admin() {
        return ("<h1>Welcome admin</h1>");
    }

    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User findUser(@PathVariable int id) {
        return userService.findById(id);
    }

    @PostMapping("/users/user-create")
    public User createUser(User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("/users/user-delete/{id}")
    public User deleteUser(@PathVariable int id) {
        User user = userService.findById(id);
        userService.deleteById(id);
        return user;
    }

    @PostMapping("/users/user-update/{id}")
    public User updateUser(@PathVariable int id, @RequestBody UserDTO userDTO) {
        return userService.updateUser(id, userDTO);
    }
}
