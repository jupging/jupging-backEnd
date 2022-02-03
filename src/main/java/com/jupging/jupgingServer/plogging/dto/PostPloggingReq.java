package com.jupging.jupgingServer.plogging.dto;

import com.jupging.jupgingServer.plogging.domain.Plogging;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
public class PostPloggingReq {

    // TODO : @Valid 설정 예정

    private MultipartFile routeImage;
    private MultipartFile trashImage;
    private Double distance;
    private int calorie;
    private int avgPaceMin;
    private int avgPaceSec;
    private int runTimeHour;
    private int runTimeMin;
    private int runTimeSec;

}
