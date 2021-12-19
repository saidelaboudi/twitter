package com.twitter.directMessage.domain.port.api;

import com.twitter.directMessage.domain.model.ConversationDomain;
import com.twitter.directMessage.domain.model.GroupDomain;
import com.twitter.directMessage.domain.model.MessageDomain;
import com.twitter.directMessage.domain.model.ReactionDomain;

import java.util.List;

public interface IDirectMessageApiPort {
    public void sendMessageToUser(MessageDomain message, Long userId);
    public GroupDomain sendMessageToGroup(MessageDomain toDomain, Long groupId);
    public MessageDomain reactToMessage(Long messageId, ReactionDomain reaction);
    public List<ConversationDomain> findUserMessages(Long userId);
    public List<MessageDomain> findGroupMessages(Long groupId);
}

