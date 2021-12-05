package com.twitter.searchService.api.ressource;

import com.twitter.searchService.domain.port.api.ISearchServiceApi;
import com.twitter.socialGraph.api.model.UserAPI;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/SearchService")
public class SearchServiceApi {
    private ISearchServiceApi searchService;

    @GetMapping("/user/{user}")
    public List<UserAPI> searchByUser(@PathVariable  String user){
        searchService.searchByUser(user);
        return null;
    }

    @GetMapping("/article/{article}")
    public List<UserAPI> searchByArticle(@PathVariable String article){
        searchService.searchByArticle(article);
        return null;
    }
    @GetMapping("/keyword/{Keyword}")
    public List<UserAPI> searchByKeyword(@PathVariable String keyword){
        searchService.searchByKeyword(keyword);
        return null;
    }
}
