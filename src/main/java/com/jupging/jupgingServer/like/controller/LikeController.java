package com.jupging.jupgingServer.like.controller;

import com.jupging.jupgingServer.like.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    @PostMapping("/{userId}/likes")
    public void like(@PathVariable Long userId) {
        // TODO : jwt 인증
        // userId - 좋아요 당하는 사람
        // fromUser - 좋아요 누르는 사람 (현재 로그인 되어 있는 사람)
        likeService.like(userId, fromUser);
    }

    @DeleteMapping("/{userId}/likes")
    public void unLike(@PathVariable Long userId) {
        // TODO : jwt 인증
        likeService.unlike(userId, fromUser);
    }
}
