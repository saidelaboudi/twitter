package com.twitter.homeTimeLine.api.ressource;

import com.twitter.homeTimeLine.api.model.KeyWordsAPI;
import com.twitter.homeTimeLine.domain.port.api.IHomeTimeLineApiPort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/homeTimeLine")
public class homeTimeLineApi {
    private IHomeTimeLineApiPort homeTimeLine;

    @PostMapping("/viewTweets")
    public void viewTweets(){

    }
    @PostMapping("/exploreTweetsByFilter")
    public void exploreTweetsByFilter(@RequestBody List<KeyWordsAPI> keyworkds){

    }
    @PostMapping("/seeTopics")
    public void seeTopics(){

    }
}
