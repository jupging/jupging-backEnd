package com.jupging.jupgingServer.like.dto;

import com.jupging.jupgingServer.user.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Getter
@Service
@NoArgsConstructor
public class PostLikeReq {
    User fromUser;
    Boolean isLike;

    public PostLikeReq(User fromUser, Boolean isLike) {
        this.fromUser = fromUser;
        this.isLike = isLike;
    }
}
