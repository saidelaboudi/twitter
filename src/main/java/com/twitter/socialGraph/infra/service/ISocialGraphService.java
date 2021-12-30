package com.twitter.socialGraph.infra.service;

import com.twitter.socialGraph.domain.model.SocialGraphDomain;
import com.twitter.socialGraph.domain.model.UserDomain;
import com.twitter.socialGraph.infra.model.SocialGraph;

import java.util.List;

public interface ISocialGraphService {
    SocialGraph update(SocialGraph socialGraph);

    SocialGraphDomain getSocialGraph(UserDomain currentUser);
}
