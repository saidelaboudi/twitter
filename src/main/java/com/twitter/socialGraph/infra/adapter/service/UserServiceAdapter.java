package com.twitter.socialGraph.infra.adapter.service;

import com.twitter.socialGraph.domain.model.UserDomain;
import com.twitter.socialGraph.domain.port.service.IUserTweeterPort;
import com.twitter.socialGraph.infra.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceAdapter implements IUserTweeterPort {
    @Autowired
    private IUserService userServices;
    @Override
    public UserDomain updateUser(UserDomain user) {
        return userServices.update(user.toInfra()).toDomain();
    }
    @Override
    public UserDomain findUserById(Long userId) {
        return userServices.findUserById(userId).toDomain();
    }
}
