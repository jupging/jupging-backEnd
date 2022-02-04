package com.jupging.jupgingServer.user.controller;

import com.jupging.jupgingServer.auth.annotation.LoginUser;
import com.jupging.jupgingServer.common.BaseResponse;
import com.jupging.jupgingServer.user.domain.User;
import com.jupging.jupgingServer.user.dto.*;
import com.jupging.jupgingServer.user.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/sign-in")
    public BaseResponse<SignInRes> signIn(@RequestBody SignInReq signInReq) {
        SignInRes signInRes = authService.signIn(signInReq);
        return new BaseResponse<>(signInRes);
    }

    @PutMapping("/sign-up")
    public BaseResponse<SignUpRes> signUp(@RequestBody SignUpReq signUpReq, @LoginUser User user) {
        // TODO : JWT 인증
        SignUpRes signUpRes = authService.signUp(user, signUpReq);
        return new BaseResponse<>(signUpRes);
    }

    @DeleteMapping("/sign-out")
    public BaseResponse<SignOutRes> signOut(@LoginUser User user) {
        SignOutRes signOutRes = authService.signOut(user);
        return new BaseResponse<>(signOutRes);
    }
}
