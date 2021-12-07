package com.twitter.directMessage.infra.service;

import com.twitter.directMessage.domain.model.GroupDomain;
import com.twitter.directMessage.infra.model.Group;

public interface IGroupeService {
    Group findGroupById(Long groupId);

    Group updateGroup(Group group);
}
