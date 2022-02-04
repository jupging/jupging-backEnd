package com.jupging.jupgingServer.badge.controller;

//import com.jupging.jupgingServer.auth.annotation.LoginUser;
import com.jupging.jupgingServer.badge.dto.GetBadgeRes;
import com.jupging.jupgingServer.badge.dto.PutBadgeReq;
import com.jupging.jupgingServer.badge.service.BadgeService;
import com.jupging.jupgingServer.common.BaseResponse;
import com.jupging.jupgingServer.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class BadgeController {

    private final BadgeService badgeService;

//    @GetMapping("/{userId}/badge")
//    public BaseResponse<GetBadgeRes> getBadge(@PathVariable Long userId, @LoginUser String name) {
//        GetBadgeRes getBadgeRes = badgeService.findBadge(userId);
//        return new BaseResponse<>(getBadgeRes);
//    }
//
//    @PutMapping("/{userId}/badge")
//    public void putBadge(@PathVariable Long userId, @LoginUser String name,
//                         @RequestBody PutBadgeReq putBadgeReq) {
//        badgeService.putBadge(userId, putBadgeReq);
//
//    }
}
