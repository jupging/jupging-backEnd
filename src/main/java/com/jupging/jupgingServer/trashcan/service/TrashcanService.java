package com.jupging.jupgingServer.trashcan.service;

import com.jupging.jupgingServer.common.BaseException;
import com.jupging.jupgingServer.trashcan.domain.Trashcan;
import com.jupging.jupgingServer.trashcan.dto.GetTrashcanRes;
import com.jupging.jupgingServer.trashcan.dto.PostTrashcanReq;
import com.jupging.jupgingServer.trashcan.dto.PostTrashcanRes;

import java.util.List;

public interface TrashcanService {
    public List<GetTrashcanRes> findTrashcans();
    public PostTrashcanRes saveTrashcan(PostTrashcanReq postTrashcanReq) throws BaseException;
    public Trashcan createTrashcan(PostTrashcanReq postTrashcanReq);
}
