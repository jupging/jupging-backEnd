package com.jupging.jupgingServer.plogging.controller;

import com.jupging.jupgingServer.common.BaseResponse;
import com.jupging.jupgingServer.plogging.dto.*;
import com.jupging.jupgingServer.plogging.service.PloggingServiceImpl;
import com.jupging.jupgingServer.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ploggings")
public class PloggingController {

    private final PloggingServiceImpl ploggingService;

    private static final String YEAR_MONTH_FORMAT = "yyyy-MM";
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern(YEAR_MONTH_FORMAT);

    /**
     * 플로깅 기록 추가 API
     * [POST] /ploggings
     * 개발자 : 홍민주
     */
    @PostMapping("")
    public BaseResponse<PostPloggingRes> postPlogging(@Valid @ModelAttribute PostPloggingReq postPloggingReq) throws Exception{
        User user = null; // TODO : jwt 확인 예정
        PostPloggingRes postPloggingRes = ploggingService.savePlogging(user, postPloggingReq);
        return new BaseResponse<>(postPloggingRes);
    }

    /**
     * 플로깅 랭크 조회 API
     * [GET] /ploggings/ranks
     * 개발자 : 홍민주
     */
    @GetMapping("/rank")
    public BaseResponse<GetRankRes> getPloggingRank(@RequestParam String sort) throws Exception{
        User user = null; // TODO : jwt 확인 예정
        String YearMonth = LocalDateTime.now().format(dtf);
        GetRankRes getRankRes = ploggingService.getRank(user, YearMonth, sort);
        return new BaseResponse<>(getRankRes);
    }

    /**
     * 플로깅 랭크 조회 API
     * [GET] /ploggings/ranks
     * 개발자 : 홍민주
     */
    @GetMapping("/rank")
    public BaseResponse<GetPloggingStatRes> getPloggingStat() throws Exception{
        Long userId = 1L; // TODO : jwt 확인 예정
        GetPloggingStatRes ploggingStatRes = ploggingService.getPloggingStat(userId);
        return new BaseResponse<>(ploggingStatRes);
    }
}
