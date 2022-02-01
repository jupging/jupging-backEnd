package com.jupging.jupgingServer.news.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@AllArgsConstructor
public class GetNewsRes {

    private Long newsId;
    private String newsImage;
    private String title;
    private String contents;
    private String link;



}
