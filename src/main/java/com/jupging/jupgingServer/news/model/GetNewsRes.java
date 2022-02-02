package com.jupging.jupgingServer.news.model;


import com.jupging.jupgingServer.news.domain.News;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class GetNewsRes {

    private Long newsId;
    private String newsImage;
    private String title;
    private String contents;
    private String link;

    public GetNewsRes(News news){
        newsId = news.getId();
        newsImage = news.getImage();
        title = news.getTitle();
        contents = news.getContents();
        link = news.getUrl();
    }
}
