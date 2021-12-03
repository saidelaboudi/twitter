package com.twitter.directMessage.domain.port.infra;

import com.twitter.directMessage.domain.model.GroupDomain;

public interface IGroupInfraPort {
    public GroupDomain findGroupById(Long groupId);
    public void update(GroupDomain group);
}
