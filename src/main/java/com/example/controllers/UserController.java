package com.example.controllers;

import com.example.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.services.UsersService;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UsersService usersService;

    @GetMapping(path = "/users")//2
    public @ResponseBody
    List<User> getAll() {
        return usersService.getAll();
    }

    @PostMapping(path = "/users", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        return usersService.save(user);
    }

    @GetMapping(path = "/users/{id}")
    @ResponseBody
    public Optional<User> get(@PathVariable("id") String id) {
        return usersService.getUser(id);
    }

    @GetMapping(path = "/users/findByEmail/{email}")
    @ResponseBody
    public User findByEmail(@PathVariable("email") String email) {
        return usersService.findByEmail(email);
    }

    @GetMapping(path = "/users/findByUsername/{username}")//1
    @ResponseBody
    public User findByUsername(@PathVariable("username") String username) {
        return usersService.findByUsername(username);
    }

    @PutMapping(path = "/users/{id}")
    @ResponseBody
    public void update(@PathVariable("id") String id, @RequestBody User user) {
        usersService.update(id, user);
    }

    @DeleteMapping(path = "/users/{id}")
    public void delete(@PathVariable("id") String id) {
        usersService.delete(id);
    }
}