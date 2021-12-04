package com.twitter.directMessage.infra.model;

import com.twitter.directMessage.domain.model.MessageDomain;
import com.twitter.socialGraph.domain.model.UserDomain;
import com.twitter.socialGraph.infra.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany
    private List<User> members;
    @OneToMany
    private List<Message> messages;

}
