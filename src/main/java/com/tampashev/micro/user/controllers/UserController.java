package com.tampashev.micro.user.controllers;

import com.tampashev.micro.user.dto.UserDto;
import com.tampashev.micro.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto create(@RequestBody UserDto userDto) {
        return userService.save(userDto);
    }

    @GetMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.FOUND)
    public List<UserDto> findAll(@RequestParam(name = "page", defaultValue = "0") int pageNumber) {
        return userService.findAll(pageNumber);
    }

    @GetMapping
    public boolean isExisted(@RequestParam(name = "user") String userName,
                             @RequestParam(name = "password") String password) {
        return userService.isExisted(userName, password);
    }
}
