package com.twitter.directMessage.domain.model;

import com.twitter.socialGraph.domain.model.UserDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupDomain {
    private Long id;
    private String name;
    private List<MessageDomain> messages;

    public void sendMessage(MessageDomain message) {
        messages.add(message);
    }
}
