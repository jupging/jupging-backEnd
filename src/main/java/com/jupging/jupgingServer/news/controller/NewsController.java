package com.jupging.jupgingServer.news.controller;

import com.jupging.jupgingServer.common.BaseResponse;
import com.jupging.jupgingServer.news.model.GetNewsRes;
import com.jupging.jupgingServer.news.service.NewsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/news")
public class NewsController {
    final private NewsServiceImpl newsService;

    /**
     * 뉴스 조회 API
     * [GET] /news
     * 개발자 : 홍민주
     */
    @GetMapping("")
    public BaseResponse<GetNewsRes> getNews(){

    }
}
