package com.twitter.directMessage.domain.usecase;

import com.twitter.directMessage.domain.model.ConversationDomain;
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
    public DirectMessage(IDirectMessageInfraPort directMessageInfra, IUserInfraPort userInfrastructure, IGroupInfraPort groupInfraPort) {
        this.directMessageInfra = directMessageInfra;
        this.userInfrastructure = userInfrastructure;
        this.groupInfraPort = groupInfraPort;
    }

    private IDirectMessageInfraPort directMessageInfra;
    private IUserInfraPort userInfrastructure;
    private IGroupInfraPort groupInfraPort;
    @Override
    public void sendMessageToUser(MessageDomain messageToSend, Long userId) {
        UserDomain user = userInfrastructure.findUserById(userId);
        user.getConversations().forEach(conversation->{
            conversation.getMessages().forEach(message->{
                if(message.getSender().equals(messageToSend.getSender())){
                    conversation.getMessages().add(messageToSend);
                }
            });
        });
        messageToSend.getSender().getConversations().forEach(conversation->{
            conversation.getMessages().forEach(message->{
                if(message.getSender().equals(user)){
                    conversation.getMessages().add(messageToSend);
                }
            });
        });
        userInfrastructure.updateUser(user);
        userInfrastructure.updateUser(messageToSend.getSender());
    }

    @Override
    public GroupDomain sendMessageToGroup(MessageDomain message, Long groupId) {
        GroupDomain group =groupInfraPort.findGroupById(groupId);
        group.getMessages().add(message);
        return groupInfraPort.update(group);
    }

    @Override
    public MessageDomain reactToMessage(Long messageId, ReactionDomain reaction) {
        MessageDomain message = directMessageInfra.findMessageById(messageId);
        message.getReactions().add(reaction);
        return directMessageInfra.updateMessage(message);
    }

    @Override
    public List<ConversationDomain> findUserMessages(Long userId) {
        UserDomain user = userInfrastructure.findUserById(userId);
        return user.getConversations();
    }

    @Override
    public List<MessageDomain> findGroupMessages(Long groupId) {
        GroupDomain group =groupInfraPort.findGroupById(groupId);
        return group.getMessages();
    }
}
