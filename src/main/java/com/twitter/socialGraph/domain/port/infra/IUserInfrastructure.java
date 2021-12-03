package com.twitter.socialGraph.domain.port.infra;

import com.twitter.socialGraph.domain.model.UserDomain;

public interface IUserInfrastructure {
    public UserDomain findUserById(Long userId);
}
