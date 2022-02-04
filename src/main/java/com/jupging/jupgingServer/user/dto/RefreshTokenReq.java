package com.jupging.jupgingServer.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RefreshTokenReq {
    String refreshToken;

    public RefreshTokenReq(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
