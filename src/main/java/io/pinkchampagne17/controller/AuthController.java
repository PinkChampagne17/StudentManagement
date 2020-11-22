package io.pinkchampagne17.controller;

import io.pinkchampagne17.entity.ErrorMessage;
import io.pinkchampagne17.entity.User;
import io.pinkchampagne17.exception.BindingResultHasErrorException;
import io.pinkchampagne17.exception.CustomException;
import io.pinkchampagne17.parameter.CreateTokenParams;
import io.pinkchampagne17.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 获取token
     */
    @PostMapping("/token")
    public ResponseEntity<?> CreateToken(
            @RequestBody @Valid CreateTokenParams params,
            BindingResult bindingResult,
            HttpServletResponse response) throws BindingResultHasErrorException, CustomException {

        if (bindingResult.hasErrors()) {
            throw new BindingResultHasErrorException(bindingResult);
        }

        User user = userService.getUserByIdAndPassword(params.getId(), params.getPassword());

        if (user == null) {
            throw new CustomException(new ErrorMessage() {
                {
                    setStatus(HttpStatus.BAD_REQUEST.value());
                    setMessage("用户名或密码不正确。");
                }
            });
        }

        response.addCookie(new Cookie("token", user.getId()) {
            {
                setMaxAge(7 * 24 * 60 * 60);
                setPath("/");
            }
        });

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
