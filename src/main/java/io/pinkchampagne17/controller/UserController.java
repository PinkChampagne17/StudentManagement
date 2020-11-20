package io.pinkchampagne17.controller;

import io.pinkchampagne17.entity.User;
import io.pinkchampagne17.exception.BindingResultHasErrorException;
import io.pinkchampagne17.parameter.CreateUserParams;
import io.pinkchampagne17.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 创建用户
     */
    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody @Valid CreateUserParams params, BindingResult bindingResult) throws BindingResultHasErrorException {

        if (bindingResult.hasErrors()) {
            throw new BindingResultHasErrorException();
        }

        User user = userService.createUser(new User() {
            {
                setId(params.getId());
                setPassword(params.getPassword());
            }
        });

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    /**
     * 通过id查找用户
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {

        User user = userService.getUserById(id);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

}
