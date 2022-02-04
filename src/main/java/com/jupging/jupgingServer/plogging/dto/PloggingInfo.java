package com.jupging.jupgingServer.plogging.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PloggingInfo {

    private String routeImage;
    private String createdDate;
    private Double distance;
    private int calorie;
    private int minute;
    private int second;
}
