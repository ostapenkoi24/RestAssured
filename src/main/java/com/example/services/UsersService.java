package com.example.services;

import com.example.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.repositories.UsersRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class UsersService {

    @Autowired
    private UsersRepository repository;

    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        repository.findAll().forEach(users::add);
        return users;
    }

    public Optional<User> getUser(String id) {
        return repository.findById(id);
    }

    public User save(User user) {
        return repository.save(user);
    }

    public void update(String id, User user) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("User " + id + " was not found");
        }

        getUser(id).ifPresent(u -> {
            u.setUsername(user.getUsername());
            u.setEmail(user.getEmail());
            u.setPassword(user.getPassword());
            repository.save(u);
        });
    }

    public void delete(String id) {
        repository.deleteById(id);
    }


    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public User findByUsername(String username) {
        return repository.findByUsername(username);
    }
}