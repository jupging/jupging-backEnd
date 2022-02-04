package com.jupging.jupgingServer.plogging.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RankInfo {

    private int rank;
    private Long userId;
    private String nickName;
    private String profile;
    private int count;
    private Double distance;
}
