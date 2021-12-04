package com.twitter.directMessage.api.ressource;

import com.twitter.directMessage.api.model.ConversationAPI;
import com.twitter.directMessage.api.model.MessageAPI;
import com.twitter.directMessage.api.model.PatternAPI;
import com.twitter.directMessage.api.model.ReactionAPI;
import com.twitter.directMessage.domain.port.api.IDirectMessageApiPort;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class DirectMessageResources {
    private IDirectMessageApiPort directMessageApiPort;

    @PostMapping("/messages/users/{userId}")
    public void sendMessageToPerson(@RequestBody MessageAPI message,@PathVariable Long userId){
        directMessageApiPort.sendMessageToUser(message.toDomain(),userId);
    }

    @PostMapping("/messages/groups/{groupId}")
    public void sendMessageToGroup(@RequestBody MessageAPI message,@PathVariable Long groupId){
        directMessageApiPort.sendMessageToGroup(message.toDomain(),groupId);
    }

    @PostMapping("/messages/{messageId}/reactions")
    public void reactToMessage(@PathVariable Long messageId,@RequestBody ReactionAPI reaction){
        directMessageApiPort.reactToMessage(messageId,reaction.toDomain());
    }

    @PostMapping("/conversations/{userId}/patters")
    public List<ConversationAPI> findUserMessages(@PathVariable Long userId){
        List<ConversationAPI> conversations =  new ArrayList<>();
        directMessageApiPort.findUserMessages(userId).forEach(conversation->{
            conversations.add(conversation.toApi());
        });
        return conversations;
    }

    @PostMapping("/messages/{groupId}/patters")
    public List<MessageAPI> findGroupMessages(@PathVariable Long groupId, List<PatternAPI> patterns){
        List<MessageAPI> messages = new ArrayList<MessageAPI>();
        directMessageApiPort.findGroupMessages(groupId).forEach(message->{
            messages.add(message.toApi());
        });
        return messages;
    }

}
