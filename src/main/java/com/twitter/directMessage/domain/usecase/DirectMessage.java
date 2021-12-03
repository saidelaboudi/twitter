package com.twitter.directMessage.domain.usecase;

import com.twitter.directMessage.api.model.PatternAPI;
import com.twitter.directMessage.domain.model.GroupDomain;
import com.twitter.directMessage.domain.model.MessageDomain;
import com.twitter.directMessage.domain.model.ReactionDomain;
import com.twitter.directMessage.domain.port.api.IDirectMessageApiPort;
import com.twitter.directMessage.domain.port.infra.IDirectMessageInfraPort;
import com.twitter.directMessage.domain.port.infra.IGroupInfraPort;
import com.twitter.socialGraph.domain.model.UserDomain;
import com.twitter.socialGraph.domain.port.infra.IUserInfraPort;

import java.util.List;

public class DirectMessage implements IDirectMessageApiPort {
    private IDirectMessageInfraPort directMessageInfra;
    private IUserInfraPort userInfrastructure;
    private IGroupInfraPort groupInfraPort;
    @Override
    public void sendMessageToUser(MessageDomain message, Long userId) {
        UserDomain user = userInfrastructure.findUserById(userId);
        user.addMessage(message);
        userInfrastructure.updateUser(user);
    }

    @Override
    public void sendMessageToGroup(MessageDomain message, Long groupId) {
        GroupDomain group =groupInfraPort.findGroupById(groupId);
        group.sendMessage(message);
        groupInfraPort.update(group);
    }

    @Override
    public void reactToMessage(Long messageId, ReactionDomain reaction) {
        MessageDomain message = directMessageInfra.findMessageById(messageId);
        message.addReaction(reaction);
    }

    @Override
    public List<MessageDomain> findUserMessages(Long userId, List<PatternAPI> patterns) {
        return null;
    }

    @Override
    public List<MessageDomain> findGroupMessages(Long groupId, List<PatternAPI> patterns) {
        return null;
    }
}
