package com.twitter.directMessage.domain.port.api;

import com.twitter.directMessage.api.model.PatternAPI;
import com.twitter.directMessage.api.model.ReactionAPI;
import com.twitter.directMessage.domain.model.MessageDomain;
import com.twitter.directMessage.domain.model.ReactionDomain;

import java.util.List;

public interface IDirectMessageApiPort {
    public void sendMessageToUser(MessageDomain message, Long userId);
    public void sendMessageToGroup(MessageDomain toDomain, Long groupId);
    public void reactToMessage(Long messageId, ReactionDomain reaction);
    public List<MessageDomain> findUserMessages(Long userId, List<PatternAPI> patterns);
    public List<MessageDomain> findGroupMessages(Long groupId, List<PatternAPI> patterns);
}

