package com.jupging.jupgingServer.user.service;

import com.jupging.jupgingServer.auth.jwt.JwtProvider;
import com.jupging.jupgingServer.user.domain.User;
import com.jupging.jupgingServer.user.dto.RefreshTokenReq;
import com.jupging.jupgingServer.user.dto.SignUpReq;
import com.jupging.jupgingServer.user.dto.SignUpRes;
import com.jupging.jupgingServer.user.dto.TokenRes;
import com.jupging.jupgingServer.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class AuthService {

    private final JwtProvider jwtProvider;
    private final UserRepository userRepository;

    public SignUpRes signUp(Long userId, SignUpReq signUpReq) {
        User user = userRepository.findById(userId)
            .orElseThrow();

        user.update(signUpReq.getNickName(), signUpReq.getProfile());
        return new SignUpRes(user.getId());
    }

    // exception 처리 수정 필요
    public TokenRes reissue(RefreshTokenReq dto) {
        String refreshToken = dto.getRefreshToken();
        if(!jwtProvider.validateToken(refreshToken));
            // throw new RuntimeException("잘못된 refreshToken");

        User user = userRepository.findByRefreshToken(refreshToken)
            .orElseThrow(() -> new RuntimeException("잘못된 refresh Token"));

        String newRefreshToken = jwtProvider.createRefreshToken();
        user.updateRefreshToken(newRefreshToken);
        String newAccessToken = jwtProvider.createAccessToken(user.getId());

        return new TokenRes(newAccessToken, newRefreshToken);

    }
}
