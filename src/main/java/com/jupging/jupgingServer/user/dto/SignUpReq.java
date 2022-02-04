package com.jupging.jupgingServer.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
public class SignUpReq {
    String nickName;
    MultipartFile profile;

    public SignUpReq(String nickName, MultipartFile profile) {
        this.nickName = nickName;
        this.profile = profile;
    }
}
