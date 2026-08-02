package com.fullstack.controllers;

import com.fullstack.entities.User;
import com.fullstack.exceptions.UserNotFoundException;
import com.fullstack.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @PostMapping("/")
    User newUser(@RequestBody User newUser){
        return  userRepo.save(newUser);
    }


    @GetMapping("/")
    List<User> getAllUsers(){
        return userRepo.findAll();
    }
    //getting single user
    @GetMapping("/{id}")
    User getUserById(@PathVariable Long id){
        return userRepo.findById(id).orElseThrow(()-> new UserNotFoundException(id));
    }
    @PutMapping("/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable Long id){
        return userRepo.findById(id).map(user -> {
            user.setUsername(newUser.getUsername());
            user.setName(newUser.getName());
            user.setEmail(newUser.getEmail());
            return userRepo.save(user);
        }).orElseThrow(()-> new UserNotFoundException(id));
    }
    //delete user
    @DeleteMapping("/{id}")
    String deleteUser(@PathVariable Long id){
        if (!userRepo.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userRepo.deleteById(id);
        return "User with id " +id+"has been deleted successfully !!";
    }

}
