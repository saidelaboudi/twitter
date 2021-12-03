package com.twitter.directMessage.infra.service;

import com.twitter.directMessage.infra.model.Message;

public interface IDirectMessageService {
    Message findMessageById(Long messageId);
}
