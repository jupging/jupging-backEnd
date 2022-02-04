package com.jupging.jupgingServer.like.service;

import com.jupging.jupgingServer.like.entity.Like;
import com.jupging.jupgingServer.like.repository.LikeRepository;
import com.jupging.jupgingServer.user.domain.User;
import com.jupging.jupgingServer.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;
    private final UserRepository userRepository;

    public boolean like(Long userId, User fromUser){
        User toUser = userRepository.findById(userId)
            .orElseThrow();

        if(isNotAlreadyLike(toUser, fromUser)) {
            likeRepository.save(new Like(toUser, fromUser));
            return true;
        }
        return false;
    }

    private boolean isNotAlreadyLike(User toUser, User fromUser) {
        return likeRepository.findByToUserAndFromUser(toUser, fromUser).isEmpty();
    }

    public void unlike(Long userId, User fromUser) {
        User toUser = userRepository.findById(userId)
            .orElseThrow();

        Like like = likeRepository.findByToUserAndFromUser(toUser, fromUser)
            .orElseThrow();
        likeRepository.delete(like);
    }

    // TODO : 좋아요 state, 좋아요 count 구현
    // -> 아마 userService에 구현해야될듯
}
