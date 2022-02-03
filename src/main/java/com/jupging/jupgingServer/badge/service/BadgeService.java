package com.jupging.jupgingServer.badge.service;

import com.jupging.jupgingServer.badge.domain.Badge;
import com.jupging.jupgingServer.badge.dto.GetBadgeRes;
import com.jupging.jupgingServer.badge.repository.BadgeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class BadgeService {

    private final BadgeRepository badgeRepository;

    public List<GetBadgeRes> findBadge(Long userId) {
        List<Badge> badgeList = badgeRepository.findByUserId(userId);
        List<GetBadgeRes> getBadgeResList= new ArrayList<>();

        for(Badge badge : badgeList)
            getBadgeResList.add(new GetBadgeRes(badge));
        return getBadgeResList;
    }
}
