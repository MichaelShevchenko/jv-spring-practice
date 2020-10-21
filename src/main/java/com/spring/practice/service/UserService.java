package com.spring.practice.service;

import com.spring.practice.model.User;
import java.util.List;

public interface UserService {
    void add(User user);

    List<User> listUsers();

    User getById(Long userId);
}
