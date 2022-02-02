package com.jupging.jupgingServer.news.service;

import com.jupging.jupgingServer.news.domain.News;
import com.jupging.jupgingServer.news.model.GetNewsRes;

import java.util.List;

public interface NewsService {
    public List<GetNewsRes> findNews();
}
