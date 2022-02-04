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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String name;

    @Column(nullable = true)
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

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    Set<Like> likes = new HashSet<>();

    @Transient
    private long likesCount;

    @Transient
    private boolean likesState;

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

    public void update(String nickName, String profile,
                       Float height, Float weight, GenderType gender) {
        this.name = nickName;
        this.picture = profile;
        this.height = height;
        this.weight = weight;
        this.genderType = gender;
    }

    public void updateLikesCount(Long likesCount) {
        this.likesCount = likesCount;
    }

    public void updateLikesState(boolean likesState) {
        this.likesState = likesState;
    }
}
