package com.twitter.directMessage.domain.port.infra;

import com.twitter.directMessage.domain.model.MessageDomain;

public interface IDirectMessageInfraPort {
    public MessageDomain findMessageById(Long messageId);
    public MessageDomain updateMessage(MessageDomain message);
}
