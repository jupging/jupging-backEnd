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
        String userName = signInReq.getEmail().split("@")[0];
        String accessToken = jwtProvider.createToken(userName);
        boolean isNew = false;
        User user = userRepository.findByEmail(signInReq.getEmail());
        if(user == null) {
            user = userRepository.save(new User(
                userName, signInReq.getEmail()));
            isNew = true;
        }

        return new SignInRes(user.getId(), accessToken, isNew);
    }

    public SignUpRes signUp(String name, SignUpReq signUpReq) {
        User user = userRepository.findByName(name).orElseThrow();
        User updateUser = user.update(signUpReq.getNickName(), signUpReq.getProfile());
        User saveUser = userRepository.save(updateUser);

        return new SignUpRes(saveUser.getId());
    }

    public SignOutRes signOut(String name) {
        User user = userRepository.findByName(name).orElseThrow();
        userRepository.delete(user);
        return new SignOutRes(userRepository.findAll());
    }
}
