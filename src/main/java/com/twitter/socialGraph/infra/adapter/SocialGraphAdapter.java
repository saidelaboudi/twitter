package com.twitter.socialGraph.infra.adapter;

import com.twitter.socialGraph.domain.model.SocialGraphDomain;
import com.twitter.socialGraph.domain.model.UserDomain;
import com.twitter.socialGraph.domain.port.infra.IUserInfraPort;
import com.twitter.socialGraph.domain.port.infra.ISocialGraphInfrastructure;
import com.twitter.socialGraph.infra.model.User;
import com.twitter.socialGraph.infra.service.ISocialGraphService;
import com.twitter.socialGraph.infra.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class SocialGraphAdapter implements ISocialGraphInfrastructure, IUserInfraPort {
    @Autowired
    private IUserService userServices;
    @Autowired
    private ISocialGraphService graphServices;

    public SocialGraphAdapter(IUserService userServices, ISocialGraphService graphServices) {
        this.userServices = userServices;
        this.graphServices = graphServices;
    }

    @Override
    public UserDomain findUserById(Long userId) {
        return userServices.findUserById(userId).toDomain();
    }

    @Override
    public UserDomain updateUser(UserDomain user) {
        return userServices.update(user.toInfra()).toDomain();
    }

    @Override
    public List<UserDomain> findUsersByUsername(String username) {
        return userServices.findUsersByUsername(username).stream().map(User::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<UserDomain> findUsersByUsernameContains(String username) {
        return userServices.findUsersByUsernameContains(username).stream().map(User::toDomain).collect(Collectors.toList());
    }

    @Override
    public UserDomain saveUser(UserDomain user) {
        return userServices.saveUser(user.toInfra()).toDomain();
    }

    @Override
    public List<UserDomain> getAllUsers() {
        return userServices.getAllUsers().stream().map(User::toDomain).collect(Collectors.toList());
    }

    @Override
    public SocialGraphDomain findSocialGraph(UserDomain currentUser) {
        return graphServices.findSocialGraphByOwner(currentUser).toDomain();
    }

    @Override
    public SocialGraphDomain update(SocialGraphDomain socialGraph) {
        return graphServices.update(socialGraph.toInfra()).toDomain();
    }
}
