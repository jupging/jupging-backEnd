package com.jupging.jupgingServer.trashcan.controller;

import com.jupging.jupgingServer.common.BaseResponse;
import com.jupging.jupgingServer.trashcan.dto.GetTrashcanRes;
import com.jupging.jupgingServer.trashcan.service.TrashcanServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/trashcan-locations")
public class TrashcanController {

    private final TrashcanServiceImpl trashcanService;

    /**
     * 쓰레기통 조회 API
     * [GET] /trashcan-locations
     * 개발자 : 홍민주
     */
    @GetMapping("")
    public BaseResponse<List<GetTrashcanRes>> getTrashcan(){
        List<GetTrashcanRes> trashcanList = trashcanService.findTrashcans();
        return new BaseResponse<>(trashcanList);
    }
}
