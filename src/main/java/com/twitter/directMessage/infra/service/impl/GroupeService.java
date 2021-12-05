package com.twitter.directMessage.infra.service.impl;

import com.twitter.directMessage.infra.model.Group;
import com.twitter.directMessage.infra.repository.GroupRepository;
import com.twitter.directMessage.infra.service.IGroupeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupeService implements IGroupeService {
    @Autowired
    private GroupRepository repository;

    @Override
    public Group findGroupById(Long groupId) {
        return repository.findById(groupId).get();
    }

    @Override
    public Group updateGroup(Group group) {
        return repository.save(group);
    }
}
