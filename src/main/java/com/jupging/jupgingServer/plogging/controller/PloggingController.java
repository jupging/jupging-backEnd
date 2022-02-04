package com.jupging.jupgingServer.plogging.controller;

import com.jupging.jupgingServer.common.BaseResponse;
import com.jupging.jupgingServer.plogging.dto.GetRankRes;
import com.jupging.jupgingServer.plogging.dto.PostPloggingReq;
import com.jupging.jupgingServer.plogging.dto.PostPloggingRes;
import com.jupging.jupgingServer.plogging.service.PloggingServiceImpl;
import com.jupging.jupgingServer.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ploggings")
public class PloggingController {

    private final PloggingServiceImpl ploggingService;

    /**
     * 플로깅 기록 추가 API
     * [POST] /ploggings
     * 개발자 : 홍민주
     */
    @PostMapping("")
    public BaseResponse<PostPloggingRes> postPlogging(@ModelAttribute PostPloggingReq postPloggingReq) throws Exception{
        User user = null; // TODO : jwt 확인 예정
        PostPloggingRes postPloggingRes = ploggingService.savePlogging(user, postPloggingReq);
        return new BaseResponse<>(postPloggingRes);
    }

    /**
     * 플로깅 랭크 조회 API
     * [GET] /ploggings/ranks
     * 개발자 : 홍민주
     */
    @PostMapping("")
    public BaseResponse<GetRankRes> getPloggingRank(@RequestParam String sort) throws Exception{
        User user = null; // TODO : jwt 확인 예정
        GetRankRes getRankRes = ploggingService.getRank(user, postPloggingReq);
        return new BaseResponse<>(getRankRes);
    }
}