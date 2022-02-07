package com.bookstore.allmine.application.services;

import com.bookstore.allmine.application.domain.PageInfo;
import com.bookstore.allmine.application.domain.User;
import com.bookstore.allmine.application.ports.UserRepository;
import com.bookstore.allmine.application.ports.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }

    @Override
    public List<User> findAll(PageInfo pageInfo) {
        return userRepository.findAll(pageInfo);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

}
