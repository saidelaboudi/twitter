package com.twitter.socialGraph.infra.service.impl;

import com.twitter.socialGraph.infra.model.User;
import com.twitter.socialGraph.infra.repository.UserRepository;
import com.twitter.socialGraph.infra.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserById(Long userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }
}
