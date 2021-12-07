package com.twitter.searchService.api.ressource;

import com.twitter.searchService.domain.port.api.ISearchServiceApi;
import com.twitter.socialGraph.api.model.UserAPI;
import com.twitter.socialGraph.domain.model.UserDomain;
import com.twitter.tweet.api.model.TweetAPI;
import com.twitter.tweet.domain.model.TweetDomain;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/api/search")
public class SearchServiceApi {
    private ISearchServiceApi searchService;

    @GetMapping("/users/{username}")
    public List<UserAPI> searchByUsername(@PathVariable String username) {
        return searchService.searchByUsername(username).stream().map(UserDomain::toAPI).collect(Collectors.toList());
    }

    @GetMapping("/articles/{article}")
    public List<UserAPI> searchByArticle(@PathVariable String article) {
        return searchService.searchByArticle(article).stream().map(UserDomain::toAPI).collect(Collectors.toList());
    }

    @GetMapping("/tweets/keywords/{keyword}")
    public List<TweetAPI> searchByKeyword(@PathVariable String keyword) {
        return searchService.searchByKeyword(keyword).stream().map(TweetDomain::toAPI).collect(Collectors.toList());
    }
}
