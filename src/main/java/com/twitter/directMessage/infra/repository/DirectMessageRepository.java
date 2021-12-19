package com.twitter.directMessage.infra.repository;

import com.twitter.directMessage.infra.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectMessageRepository extends JpaRepository<Message,Long> {
}
