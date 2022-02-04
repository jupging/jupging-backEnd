package com.jupging.jupgingServer.user.service;

import com.jupging.jupgingServer.auth.jwt.JwtProvider;
import com.jupging.jupgingServer.user.domain.User;
import com.jupging.jupgingServer.user.dto.SignUpReq;
import com.jupging.jupgingServer.user.dto.SignUpRes;
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
}
