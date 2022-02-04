package com.jupging.jupgingServer.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SignUpReq {
    String nickName;
    String profile;

    public SignUpReq(String nickName, String profile) {
        this.nickName = nickName;
        this.profile = profile;
    }
}
