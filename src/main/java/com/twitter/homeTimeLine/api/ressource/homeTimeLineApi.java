package com.twitter.homeTimeLine.api.ressource;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/homeTimeLine")
public class homeTimeLineApi {


    @PutMapping("/viewTweets")
    public void viewTweets(){
        //socialGraph.reportUser(currentUserId,userId);
    }
    @PutMapping("/exploreTweetsByFilter")
    public void exploreTweetsByFilter(){
        //socialGraph.followUser(currentUserId,userId);
    }
    @PutMapping("/seeTopics")
    public void seeTopics(){
        //socialGraph.blockUser(currentUserId,userId);
    }
}
