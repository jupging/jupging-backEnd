package com.jupging.jupgingServer.user.controller;

import com.jupging.jupgingServer.auth.annotation.LoginUser;
import com.jupging.jupgingServer.common.BaseResponse;
import com.jupging.jupgingServer.user.domain.User;
import com.jupging.jupgingServer.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;


}
