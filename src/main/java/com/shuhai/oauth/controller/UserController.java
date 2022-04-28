package com.shuhai.oauth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("getCurrentUser")
    public Principal getCurrentUser(Principal principal) {
        return principal;
    }
}
