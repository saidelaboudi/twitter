package com.twitter.socialGraph.infra.service.impl;

import com.twitter.socialGraph.infra.model.User;
import com.twitter.socialGraph.infra.repository.UserRepository;
import com.twitter.socialGraph.infra.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserById(Long userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findUsersByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findUsersByUsernameContains(String username) {
        return userRepository.findUsersByUsernameContains(username);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
