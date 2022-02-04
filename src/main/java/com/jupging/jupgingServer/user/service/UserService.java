package com.jupging.jupgingServer.user.service;

import com.jupging.jupgingServer.user.domain.User;
import com.jupging.jupgingServer.user.domain.enums.GenderType;
import com.jupging.jupgingServer.user.dto.PutUserInfoReq;
import com.jupging.jupgingServer.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public void putUserInfo(Long userId, PutUserInfoReq req) {
        User user = userRepository.findById(userId)
            .orElseThrow();

        GenderType gender;
        if(req.getGender() == "male") gender = GenderType.MALE;
        else gender = GenderType.FEMALE;

        user.update(req.getNickName(), req.getProfile(),
            req.getHeight(), req.getWeight(), gender);

    }

}
