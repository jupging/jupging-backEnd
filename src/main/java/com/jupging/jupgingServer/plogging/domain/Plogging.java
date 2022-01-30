package com.jupging.jupgingServer.plogging.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Plogging {

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

    // TODO : user 예정
    // TODO : BaseTomeEntity 예정

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
}
