package com.twitter.homeTimeLine.infra.repository;

import com.twitter.homeTimeLine.infra.model.HomeTimeLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeTimeLineRepo extends JpaRepository<HomeTimeLine,Long> {

}
