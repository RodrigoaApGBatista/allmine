package com.bookstore.allmine.adapters.inbound;

import com.bookstore.allmine.adapters.dtos.UserDto;
import com.bookstore.allmine.application.domain.PageInfo;
import com.bookstore.allmine.application.domain.User;
import com.bookstore.allmine.application.ports.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userServicePort;

    @PostMapping(produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<User> create(@RequestBody @Valid UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        return new ResponseEntity<>(userServicePort.createUser(user), HttpStatus.CREATED);
    }

    @PutMapping(produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<User> update(@RequestBody @Valid UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        return new ResponseEntity<>(userServicePort.updateUser(user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable("id") UUID id) {
        userServicePort.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(produces = {"application/json"})
    public ResponseEntity<?> findAll(@PageableDefault(page = 0,
            size = 5,
            sort = "name",
            direction = Sort.Direction.DESC) Pageable pageable){
        PageInfo pageInfo = new PageInfo();
        BeanUtils.copyProperties(pageable, pageInfo);
        List<User> userList = userServicePort.findAll(pageInfo);
        return new ResponseEntity<>(new PageImpl<User>(userList, pageable, userList.size()), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = {"application/json"})
    public ResponseEntity<Object> findById(@PathVariable(value="id") UUID userId) {
        Optional<User> userModelOptional = userServicePort.findById(userId);
        return userModelOptional.<ResponseEntity<Object>>map(user -> ResponseEntity.status(HttpStatus.OK).body(user))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found."));
    }

}
