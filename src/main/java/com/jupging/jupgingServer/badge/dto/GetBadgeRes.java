package com.jupging.jupgingServer.badge.dto;

import com.jupging.jupgingServer.badge.domain.Badge;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class GetBadgeRes {
    Long badgeId;
    String badgeName;
    String badgeDescription;
    String badgeImage;

    public GetBadgeRes(Badge badge) {
        this.badgeId = badge.getId();
        this.badgeName = badge.getTitle();
        this.badgeDescription = badge.getDescription();
        this.badgeImage = badge.getImage();
    }
}
