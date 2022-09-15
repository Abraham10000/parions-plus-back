package com.example.back.controller;


import com.example.back.model.User;
import com.example.back.service.userService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@Controller
@Data
public class UserController {

    private final userService userservice;

    @GetMapping("/")
    public String helloApi(){
        return "Hello World it's work";
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userservice.getALl();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id){
        return userservice.getById(id);
    }

    @GetMapping("/users/{name}")
    public List<User> getByName(@PathVariable String value){ return  userservice.findName(value);}

    @PostMapping("/user")
    public User AddUser(@RequestBody User userToAdd){ return  userservice.addUser(userToAdd);}

    @PatchMapping("/user/{id}")
    public User updateUserName(@PathVariable Long id_user,@RequestBody String newname){
        return userservice.UpdateUser(id_user, newname);
    }

    @DeleteMapping("/user/{id}")
    public String DeleteUser(@PathVariable Long id_user){
        return  userservice.DeleteUserById(id_user);
    }
}
