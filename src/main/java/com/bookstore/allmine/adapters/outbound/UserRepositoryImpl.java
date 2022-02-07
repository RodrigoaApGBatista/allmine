package com.bookstore.allmine.adapters.outbound;

import com.bookstore.allmine.adapters.outbound.entities.UserEntity;
import com.bookstore.allmine.application.domain.Book;
import com.bookstore.allmine.application.domain.PageInfo;
import com.bookstore.allmine.application.domain.User;
import com.bookstore.allmine.application.ports.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@Primary
public class UserRepositoryImpl implements UserRepository {

    private final SpringDataUserRepository userRepository;

    public UserRepositoryImpl(SpringDataUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    ModelMapper modelMapper;

    @Override
    public User save(User user) {
        UserEntity emailEntity = userRepository.save(modelMapper.map(user, UserEntity.class));
        return modelMapper.map(emailEntity, User.class);
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public List<User> findAll(PageInfo pageInfo) {
        return null;
    }

    @Override
    public Optional<User> findById(UUID id) {
        return Optional.empty();
    }

}
