package com.jupging.jupgingServer.user.service;

import com.jupging.jupgingServer.auth.jwt.JwtProvider;
import com.jupging.jupgingServer.user.domain.User;
import com.jupging.jupgingServer.user.dto.*;
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

    public SignInRes signIn(SignInReq signInReq) {
        User user = userRepository.findByEmail(signInReq.getEmail());

        boolean isNew = false;
        if(user == null) {
            user = userRepository.save(new User(signInReq.getEmail()));
            isNew = true;
        }

        String accessToken = jwtProvider.createJwt(user.getId());
        return new SignInRes(user.getId(), accessToken, isNew);
    }

    public SignUpRes signUp(Long userId, SignUpReq signUpReq) {
        User user = userRepository.findById(userId).orElseThrow();
        User updateUser = user.update(signUpReq.getNickName(), signUpReq.getProfile());
        User saveUser = userRepository.save(updateUser);

        return new SignUpRes(saveUser.getId());
    }

    public SignOutRes signOut(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        userRepository.delete(user);
        return new SignOutRes(userRepository.findAll());
    }
}
