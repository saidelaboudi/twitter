package com.twitter.socialGraph.infra.repository;

import com.twitter.socialGraph.infra.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findByUsername(String username);
    List<User> findUsersByUsernameContains(String username);
}
