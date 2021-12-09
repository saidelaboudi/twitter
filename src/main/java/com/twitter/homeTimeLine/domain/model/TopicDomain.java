package com.twitter.homeTimeLine.domain.model;

import com.twitter.homeTimeLine.api.model.TopicApi;
import com.twitter.homeTimeLine.infra.model.Topic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopicDomain {

    private Long id;
    private String description;

    public TopicApi toApi() {
        return new TopicApi(this.id,this.description);
    }
    public Topic toInfra(){
        return null;
    }
}
