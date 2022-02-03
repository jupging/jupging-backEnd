package com.jupging.jupgingServer.trashcan.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PostTrashcanReq {
    private Double latitude;
    private Double longitude;
}
