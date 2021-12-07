package com.twitter.userTimeLineService.infra.repository;

import com.twitter.userTimeLineService.infra.model.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTimeLineRepository extends JpaRepository<Tweet,Long> {
}