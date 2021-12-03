package com.twitter.socialGraph.domain.port.infra;

import com.twitter.socialGraph.domain.model.UserDomain;

public interface IUserInfraPort {
    public UserDomain findUserById(Long userId);
    public void updateUser(UserDomain user);
}
