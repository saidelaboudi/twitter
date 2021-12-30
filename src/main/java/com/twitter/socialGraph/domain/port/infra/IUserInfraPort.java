package com.twitter.socialGraph.domain.port.infra;

import com.twitter.socialGraph.domain.model.SocialGraphDomain;
import com.twitter.socialGraph.domain.model.UserDomain;

import java.util.List;

public interface IUserInfraPort {
    public UserDomain findUserById(Long userId);
    public UserDomain updateUser(UserDomain user);
    public List<UserDomain> findUsersByUsername(String username);
    public List<UserDomain> findUsersByUsernameContains(String username);
    public UserDomain saveUser(UserDomain user);
    public List<UserDomain> getAllUsers();

    List<UserDomain> getAllFollowed(Long userId);
}
