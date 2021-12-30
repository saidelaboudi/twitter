package com.twitter.socialGraph.domain.port.infra;

import com.twitter.socialGraph.domain.model.SocialGraphDomain;
import com.twitter.socialGraph.domain.model.UserDomain;

public interface ISocialGraphInfrastructure {
    public SocialGraphDomain findSocialGraph(UserDomain currentUserDomain);

    public SocialGraphDomain update(SocialGraphDomain socialGraphDomain);

}
