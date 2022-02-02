package com.jupging.jupgingServer.user.domain;

import com.jupging.jupgingServer.common.BaseTimeEntity;
import com.jupging.jupgingServer.user.domain.enums.GenderType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = true)
    private String picture;

    @Column(nullable = true)
    private Float height;

    @Column(nullable = true)
    private Float weight;

    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private GenderType genderType;

    @Column(nullable = true)
    private String refreshToken;

    @Builder
    public User(String name, String email, String picture) {
        this.name = name;
        this.email = email;
        this.picture = picture;
    }

    public User update(String name, String picture) {
        this.name = name;
        this.picture = picture;

        return this;
    }

    public void updateRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
