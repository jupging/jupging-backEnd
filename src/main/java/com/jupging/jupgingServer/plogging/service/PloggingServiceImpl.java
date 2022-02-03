package com.jupging.jupgingServer.plogging.service;

import com.jupging.jupgingServer.common.GCSuploader;
import com.jupging.jupgingServer.plogging.domain.Plogging;
import com.jupging.jupgingServer.plogging.dto.PostPloggingReq;
import com.jupging.jupgingServer.plogging.dto.PostPloggingRes;
import com.jupging.jupgingServer.plogging.repository.PloggingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PloggingServiceImpl implements PloggingService{

    private final PloggingRepository ploggingRepository;
    private final GCSuploader GCSuploader;
    @Override
    public PostPloggingRes savePlogging(PostPloggingReq postPloggingReq) throws Exception {
        String routeImage = GCSuploader.uploadFile(postPloggingReq.getRouteImage(), "plogging");
        String trashImage = GCSuploader.uploadFile(postPloggingReq.getTrashImage(), "plogging");
    }

    @Override
    public Plogging createPlogging(PostPloggingReq postPloggingReq) throws Exception {

    }
}
