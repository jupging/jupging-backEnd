package com.jupging.jupgingServer.user.controller;

import com.jupging.jupgingServer.common.BaseResponse;
import com.jupging.jupgingServer.user.domain.User;
import com.jupging.jupgingServer.user.dto.PutUserInfoReq;
import com.jupging.jupgingServer.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PutMapping("/{userId}")
    public void putUserInfo(@PathVariable Long userId, @RequestBody PutUserInfoReq putUserInfoReq) {
        // TODO : JWT 인증
        userService.putUserInfo(userId, putUserInfoReq);
    }

//    @GetMapping("/{userId}/info")
//    public BaseResponse<GetUserInfoRes> getUserInfo(@PathVariable Long userId)


}
