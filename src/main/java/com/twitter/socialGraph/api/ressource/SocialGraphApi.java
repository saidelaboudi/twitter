package com.twitter.socialGraph.api.ressource;

import com.twitter.socialGraph.api.model.UserAPI;
import com.twitter.socialGraph.domain.model.UserDomain;
import com.twitter.socialGraph.domain.port.api.ISocialGraphAPI;
import com.twitter.socialGraph.domain.port.api.IUserApiPort;
import com.twitter.socialGraph.infra.model.SocialGraph;
import com.twitter.socialGraph.infra.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/api/socialGraph/users")
public class SocialGraphApi {
    private final ISocialGraphAPI socialGraph;
    private final IUserApiPort userApiPort;

    public SocialGraphApi(ISocialGraphAPI socialGraph, IUserApiPort userApiPort) {
        this.socialGraph = socialGraph;
        this.userApiPort = userApiPort;
    }

    @PutMapping("/{currentUserId}/reports/{userId}")
    public void reportUser(@PathVariable Long currentUserId, @PathVariable Long userId) {
        socialGraph.reportUser(currentUserId, userId);
    }

    @PutMapping("/{currentUserId}/follows/{userId}")
    public void followUser(@PathVariable Long currentUserId, @PathVariable Long userId) {
        socialGraph.followUser(currentUserId, userId);
    }

    @PutMapping("/{currentUserId}/blocks/{userId}")
    public void blockUser(@PathVariable Long currentUserId, @PathVariable Long userId) {
        socialGraph.blockUser(currentUserId, userId);
    }

    @PostMapping("/users")
    public UserDomain addUser(@RequestBody UserAPI user) {
        return userApiPort.save(user.toDomain());
    }

    @GetMapping("/users")
    public List<UserDomain> getAllUser() {
        return userApiPort.getAll();
    }

    @GetMapping("/users/{userId}")
    public UserDomain getUserById(@PathVariable Long userId) {
        return userApiPort.findUserById(userId);
    }

}
