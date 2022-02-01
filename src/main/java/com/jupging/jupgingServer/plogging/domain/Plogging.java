package com.jupging.jupgingServer.plogging.domain;

import com.jupging.jupgingServer.common.BaseTimeEntity;
import com.jupging.jupgingServer.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Plogging extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String routeImage;

    private String trashImage;

    @Column(nullable = false)
    private int avgPaceMin;

    @Column(nullable = false)
    private int avgPaceSec;

    @Column(nullable = false)
    private int calorie;

    @Column(nullable = false)
    private Double distance;

    @Column(nullable = false)
    private int runTimeHour;

    @Column(nullable = false)
    private int runTimeMin;

    @Column(nullable = false)
    private int runTimeSec;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
