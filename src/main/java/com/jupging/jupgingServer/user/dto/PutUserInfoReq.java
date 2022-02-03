package com.jupging.jupgingServer.user.dto;

import com.nimbusds.openid.connect.sdk.claims.Gender;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Getter
@Service
public class PutUserInfoReq {
    String nickName;
    String profile;
    Float height;
    Float weight;
    String gender;

    public PutUserInfoReq(String nickName, String profile,
                          Float height, Float weight, String gender) {
        this.nickName = nickName;
        this.profile = profile;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
    }
}
