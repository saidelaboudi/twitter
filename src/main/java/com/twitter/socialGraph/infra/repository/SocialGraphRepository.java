package com.twitter.socialGraph.infra.repository;

import com.twitter.socialGraph.domain.model.SocialGraphDomain;
import com.twitter.socialGraph.domain.model.UserDomain;
import com.twitter.socialGraph.infra.model.SocialGraph;
import com.twitter.socialGraph.infra.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SocialGraphRepository extends JpaRepository<SocialGraph,Long> {
    SocialGraph findByOwner(User currentUser);
}
