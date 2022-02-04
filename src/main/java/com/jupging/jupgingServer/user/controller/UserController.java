package com.jupging.jupgingServer.user.controller;

import com.jupging.jupgingServer.auth.annotation.LoginUser;
import com.jupging.jupgingServer.common.BaseResponse;
import com.jupging.jupgingServer.user.domain.User;
import com.jupging.jupgingServer.user.dto.GetUserInfoRes;
import com.jupging.jupgingServer.user.dto.PutUserInfoReq;
import com.jupging.jupgingServer.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{userId}/info")
    public BaseResponse<GetUserInfoRes> getUserInfo(@PathVariable Long userId, @LoginUser User user) {
        // @LoginUser가 정상작동 된다면 userId, user.getId() 값이 똑같아야 됨.
        GetUserInfoRes getUserInfoRes = userService.getUserInfo(user);
        return new BaseResponse<>(getUserInfoRes);
    }


}
