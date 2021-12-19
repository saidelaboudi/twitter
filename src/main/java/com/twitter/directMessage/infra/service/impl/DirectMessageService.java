package com.twitter.directMessage.infra.service.impl;

import com.twitter.directMessage.infra.model.Message;
import com.twitter.directMessage.infra.repository.DirectMessageRepository;
import com.twitter.directMessage.infra.service.IDirectMessageService;
import org.springframework.stereotype.Service;

@Service
public class DirectMessageService implements IDirectMessageService {
    private DirectMessageRepository directMessageRepository;
    @Override
    public Message findMessageById(Long messageId) {
        return directMessageRepository.findById(messageId).get();
    }

    @Override
    public Message updateMessage(Message message) {
        return directMessageRepository.save(message);
    }
}
