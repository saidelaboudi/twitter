package com.twitter.homeTimeLine.domain.model;


import com.twitter.homeTimeLine.api.model.TweetAPI;
import com.twitter.homeTimeLine.infra.model.Tweet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TweetDomain {


    public TweetAPI toApi() {
        return null;
    }
    public Tweet toInfra(){
        return null;
    }
}
