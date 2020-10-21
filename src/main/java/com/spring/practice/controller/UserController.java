package com.spring.practice.controller;

import com.spring.practice.dto.UserResponseDto;
import com.spring.practice.model.User;
import com.spring.practice.service.UserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/inject")
    public String injectData() {
        userService.add(new User("Richard", "Feynman", "physics.rules@gmail.com"));
        userService.add(new User("Hell", "Jordan", "lantern.guardian@nova.com"));
        userService.add(new User("Hagoromo", "Otsutsuki", "rikudo@bing.com"));
        userService.add(new User("Alexander", "Usyk", "boxing.master@gmail.com"));
        return "users were added successfully";
    }

    @GetMapping("/{userId}")
    public UserResponseDto get(@PathVariable Long userId) {
        return castUserToDto(userService.getById(userId));
    }

    @GetMapping
    public List<UserResponseDto> getAll() {
        List<UserResponseDto> result = new ArrayList<>();
        for (User user : userService.listUsers()) {
            result.add(castUserToDto(user));
        }
        return result;
    }

    private UserResponseDto castUserToDto(User user) {
        UserResponseDto userDto = new UserResponseDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
