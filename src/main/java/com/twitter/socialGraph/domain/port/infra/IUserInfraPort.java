package com.twitter.socialGraph.domain.port.infra;

import com.twitter.socialGraph.domain.model.UserDomain;

import java.util.List;

public interface IUserInfraPort {
    public UserDomain findUserById(Long userId);
    public UserDomain updateUser(UserDomain user);
    public List<UserDomain> findUsersByUsername(String username);
}
