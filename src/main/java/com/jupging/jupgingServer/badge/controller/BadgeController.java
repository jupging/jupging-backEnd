package com.jupging.jupgingServer.badge.controller;

import com.jupging.jupgingServer.badge.dto.GetBadgeRes;
import com.jupging.jupgingServer.badge.service.BadgeService;
import com.jupging.jupgingServer.common.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class BadgeController {

    private final BadgeService badgeService;

    @GetMapping("/{userId}/badge")
    public BaseResponse<List<GetBadgeRes>> getBadge(@PathVariable Long userId) {
        // TODO : jwt 인증필요
        List<GetBadgeRes> badgeList = badgeService.findBadge(userId);
        return new BaseResponse<>(badgeList);
    }
}
