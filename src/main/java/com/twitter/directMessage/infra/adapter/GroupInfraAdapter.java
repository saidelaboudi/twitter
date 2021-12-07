package com.twitter.directMessage.infra.adapter;

import com.twitter.directMessage.domain.model.GroupDomain;
import com.twitter.directMessage.domain.port.infra.IGroupInfraPort;
import com.twitter.directMessage.infra.service.IGroupeService;
import com.twitter.directMessage.infra.service.impl.GroupeService;
import org.springframework.beans.factory.annotation.Autowired;

public class GroupInfraAdapter implements IGroupInfraPort {
    @Autowired
    private IGroupeService iGroupeService;

    public GroupInfraAdapter(IGroupeService iGroupeService) {
        this.iGroupeService = iGroupeService;
    }

    @Override
    public GroupDomain findGroupById(Long groupId) {
        return iGroupeService.findGroupById(groupId).toDomain();
    }

    @Override
    public GroupDomain update(GroupDomain group) {
        return iGroupeService.updateGroup(group.toInfra()).toDomain();
    }
}
