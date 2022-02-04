package com.jupging.jupgingServer.plogging.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetPloggingStatRes {

    private Double totalDistance;
    private int totalCalorie;
    private int totalCount;
    private int totalMin;
    private int totalSec;
    private List<PloggingInfo> ploggingList;
}
