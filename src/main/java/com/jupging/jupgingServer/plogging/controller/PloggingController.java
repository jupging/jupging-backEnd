package com.jupging.jupgingServer.plogging.controller;

import com.jupging.jupgingServer.common.BaseResponse;
import com.jupging.jupgingServer.common.GCSuploader;
import com.jupging.jupgingServer.plogging.dto.PostPloggingReq;
import com.jupging.jupgingServer.plogging.dto.PostPloggingRes;
import com.jupging.jupgingServer.plogging.service.PloggingServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        // TODO : jwt 확인
        // TODO : ServletException, GoogleJsonResponseException 예외 처리 (merge후 ControllerAdvice에서 예외처리할 예정)
        PostPloggingRes postPloggingRes = ploggingService.savePlogging(postPloggingReq);
        return new BaseResponse<>(postPloggingRes);
    }
}
