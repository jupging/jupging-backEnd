package com.jupging.jupgingServer.user.controller;

import com.jupging.jupgingServer.common.BaseResponse;
import com.jupging.jupgingServer.user.dto.RefreshTokenReq;
import com.jupging.jupgingServer.user.dto.TokenRes;
import com.jupging.jupgingServer.user.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/reissue")
    public BaseResponse<TokenRes> reissue(RefreshTokenReq RefreshtokenReq) {
        TokenRes tokenRes = authService.reissue(RefreshtokenReq);
        return new BaseResponse<>(tokenRes);
    }
}
