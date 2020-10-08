package io.pinkchampagne17.controller;

import io.pinkchampagne17.entity.User;
import io.pinkchampagne17.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<?> addUser(@Valid User user, BindingResult bindingResult) {

        user = userService.addUser(user);

        if (user == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Long id) {

        User user = userService.getUserById(id);

        if (user != null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

//    @GetMapping()
//    public User getUserByName(@RequestParam("name") @NotNull @NotBlank String name) {
//
//    }

//    @PutMapping("/{id}/name")
//    public User updateUserName(@PathVariable Long id, @RequestAttribute String name) {
//        return null;
//    }
//
//    @PutMapping("/{id}/password")
//    public User updatePassword(@PathVariable("id") Long id, @RequestBody String password) {
//        var user = userRepository.updatePassword(id, password);
//        return user;
//    }

}
