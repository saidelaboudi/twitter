package com.twitter.userTimeLineService.infra.repository;

import com.twitter.directMessage.infra.model.Reaction;
import com.twitter.socialGraph.infra.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReactionRepository extends JpaRepository<Reaction, Long> {
    List<Reaction> findByUser(User user);
}
