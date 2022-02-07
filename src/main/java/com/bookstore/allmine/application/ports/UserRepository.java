package com.bookstore.allmine.application.ports;

import com.bookstore.allmine.application.domain.PageInfo;
import com.bookstore.allmine.application.domain.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {

    User save(User user);
    void delete(UUID id);
    List<User> findAll(PageInfo pageInfo);
    Optional<User> findById(UUID id);

}
