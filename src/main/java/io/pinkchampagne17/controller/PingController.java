package io.pinkchampagne17.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    /**
     * 心跳检测
     */
    @GetMapping({ "/", "/ping" })
    public Object ping() {
        return new Object() {
            public final String message = "pong";
        };
    }

}
