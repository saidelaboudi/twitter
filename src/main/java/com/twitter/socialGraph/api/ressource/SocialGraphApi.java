package com.twitter.socialGraph.api.ressource;

import com.twitter.socialGraph.domain.port.api.ISocialGraphAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/socialGraph/users")
public class SocialGraphApi {
    private final ISocialGraphAPI socialGraph;

    public SocialGraphApi(ISocialGraphAPI socialGraph) {
        this.socialGraph = socialGraph;
    }

    @PutMapping("/{currentUserId}/reports/{userId}")
    public void reportUser(@PathVariable Long currentUserId,@PathVariable  Long userId){
        socialGraph.reportUser(currentUserId,userId);
    }
    @PutMapping("/{currentUserId}/follows/{userId}")
    public void followUser(@PathVariable Long currentUserId,@PathVariable Long userId){
        socialGraph.followUser(currentUserId,userId);
    }
    @PutMapping("/{currentUserId}/blocks/{userId}")
    public void blockUser(@PathVariable Long currentUserId,@PathVariable Long userId){
        socialGraph.blockUser(currentUserId,userId);
    }
}
