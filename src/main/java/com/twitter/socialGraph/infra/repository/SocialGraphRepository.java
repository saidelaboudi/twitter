package com.twitter.socialGraph.infra.repository;

import com.twitter.socialGraph.infra.model.SocialGraph;
import com.twitter.socialGraph.infra.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialGraphRepository extends JpaRepository<SocialGraph,Long> {
}
