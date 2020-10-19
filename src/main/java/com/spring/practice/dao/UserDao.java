package com.spring.practice.dao;

import com.spring.practice.model.User;
import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> listUsers();
}
