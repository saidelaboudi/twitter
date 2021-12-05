package com.twitter.directMessage.infra.model;

import com.twitter.directMessage.domain.model.GroupDomain;
import com.twitter.directMessage.domain.model.MessageDomain;
import com.twitter.socialGraph.domain.model.UserDomain;
import com.twitter.socialGraph.infra.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    private List<User> members = new ArrayList<User>();
    @OneToMany(cascade = CascadeType.ALL)
    private List<Message> messages = new ArrayList<Message>();

    public GroupDomain toDomain() {
        List<UserDomain> members = new ArrayList<>();
        List<MessageDomain> messages = new ArrayList<>();
        if(!members.isEmpty())
            this.members.forEach(member->{
                members.add(member.toDomain());
            });
        if(!messages.isEmpty())
            this.messages.forEach(message->{
                messages.add(message.toDomain());
            });
        return new GroupDomain(
                this.id,
                this.name,
                members,
                messages
        );
    }
}
