package com.jupging.jupgingServer.trashcan.service;

import com.jupging.jupgingServer.trashcan.dto.GetTrashcanRes;

import java.util.List;

public interface TrashcanService {
    public List<GetTrashcanRes> findTrashcans();
}
