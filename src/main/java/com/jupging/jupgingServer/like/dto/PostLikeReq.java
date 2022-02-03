package com.jupging.jupgingServer.like.dto;

import com.jupging.jupgingServer.user.domain.User;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Getter
@Service
public class PostLikeReq {
    User fromUser;

    public PostLikeReq(User fromUser) {
        this.fromUser = fromUser;
    }
}
