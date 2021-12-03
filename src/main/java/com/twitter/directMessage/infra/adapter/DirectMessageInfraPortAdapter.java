package com.twitter.directMessage.infra.adapter;

import com.twitter.directMessage.domain.model.MessageDomain;
import com.twitter.directMessage.domain.port.infra.IDirectMessageInfraPort;
import com.twitter.directMessage.infra.service.IDirectMessageService;

public class DirectMessageInfraPortAdapter implements IDirectMessageInfraPort {
    private IDirectMessageService directMessageServices;
    @Override
    public MessageDomain findMessageById(Long messageId) {
        return directMessageServices.findMessageById(messageId).toDomain();
    }
}
