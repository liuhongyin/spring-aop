package com.liuhongyin.springaop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author marcot
 * @since 11/10/19
 */
@RestController
@Slf4j
public class LoginController {

    @GetMapping("/login")
    public String login(
            @RequestParam String username,
            @RequestParam String password
    ) {
        log.info("username,{}", username);
        log.info("password,{}", password);
//        throw new RuntimeException("test");
        return "success";
    }
}
