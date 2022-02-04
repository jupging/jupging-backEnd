package com.jupging.jupgingServer.user.dto;

import lombok.Getter;

@Getter
public class SignUpRes {
    Long userId;

    public SignUpRes(Long userId) {
        this.userId = userId;
    }
}
