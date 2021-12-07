package com.twitter.directMessage.domain.model;

import com.twitter.directMessage.api.model.GroupAPI;
import com.twitter.directMessage.api.model.MessageAPI;
import com.twitter.directMessage.infra.model.Group;
import com.twitter.directMessage.infra.model.Message;
import com.twitter.socialGraph.api.model.UserAPI;
import com.twitter.socialGraph.domain.model.UserDomain;
import com.twitter.socialGraph.infra.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupDomain {
    private Long id;
    private String name;
    private List<UserDomain> members;
    private List<MessageDomain> messages;

    public void sendMessage(MessageDomain message) {
        messages.add(message);
    }

    public GroupAPI toAPI() {
        List<UserAPI> members =  new ArrayList<>();
        List<MessageAPI> messages =  new ArrayList<>();
        if (!this.messages.equals(null))
            this.messages.forEach(message->{
                messages.add(message.toApi());
            });
        if (!this.members.equals(null))
            this.members.forEach(member->{
                members.add(member.toAPI());
            });

        return new GroupAPI(
                this.id,
                this.name,
                members,
                messages
        );
    }

    public Group toInfra() {
        List<User> members =  new ArrayList<>();
        List<Message> messages =  new ArrayList<>();
        if (!this.messages.equals(null))
            this.messages.forEach(message->{
                messages.add(message.toInfra());
            });
        if (!this.members.equals(null))
            this.members.forEach(member->{
                members.add(member.toInfra());
            });

        return new Group(
                this.id,
                this.name,
                members,
                messages
        );
    }

}
