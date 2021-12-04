package com.twitter.user.api;

import com.twitter.socialGraph.infra.model.User;
import com.twitter.socialGraph.infra.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class UserAPI {
    private UserRepository userRepository;
    @PostMapping("/users")
    public User addUser(@RequestBody User user){
        return userRepository.save(user);
    }
    @GetMapping("/users")
    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable Long userId){
        return userRepository.findById(userId).get();
    }
}
