package com.twitter.user.api;

import com.twitter.socialGraph.infra.model.SocialGraph;
import com.twitter.socialGraph.infra.model.User;
import com.twitter.socialGraph.infra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class UserControllerAPI {
    private final UserRepository userRepository;

    public UserControllerAPI(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user){
        user.setConversations(new ArrayList<>());
        user.setRetweets(new ArrayList<>());
        user.setSharedTweets(new ArrayList<>());
        user.setTweets(new ArrayList<>());
        user.setSocialGraph(new SocialGraph());
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
