package com.jupging.jupgingServer.plogging.service;

import com.jupging.jupgingServer.plogging.domain.Plogging;
import com.jupging.jupgingServer.plogging.dto.PostPloggingReq;
import com.jupging.jupgingServer.plogging.dto.PostPloggingRes;

public interface PloggingService {

    public PostPloggingRes savePlogging(PostPloggingReq postPloggingReq) throws Exception;
    public Plogging createPlogging(PostPloggingReq postPloggingReq) throws Exception;
}
