package com.jupging.jupgingServer.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpReq {
    String nickName;
    String profile;

    public SignUpReq(String nickName, String profile) {
        this.nickName = nickName;
        this.profile = profile;
    }
}
