package com.twitter.directMessage.api.model;

import com.twitter.directMessage.domain.model.GroupDomain;
import com.twitter.directMessage.domain.model.MessageDomain;
import com.twitter.socialGraph.api.model.UserAPI;
import com.twitter.socialGraph.domain.model.UserDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupAPI {
    private Long id;
    private String name;
    private List<UserAPI> members;
    private List<MessageAPI> messages;

    public GroupDomain toDomain() {
        List<UserDomain> users = new ArrayList<>();
        List<MessageDomain> messages = new ArrayList<>();
        this.members.forEach(user->{
            users.add(user.toDomain());
        });
        this.messages.forEach(message->{
            messages.add(message.toDomain());
        });
        return new GroupDomain(
                this.id,
                this.name,
                users,
                messages
        );
    }
}
