package com.example.repositories;

import com.example.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, String> {

    User findByEmail(String email);

    User findByUsername(String username);

}