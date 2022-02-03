package com.jupging.jupgingServer.plogging.service;

import com.jupging.jupgingServer.common.GCSuploader;
import com.jupging.jupgingServer.plogging.domain.Plogging;
import com.jupging.jupgingServer.plogging.dto.PostPloggingReq;
import com.jupging.jupgingServer.plogging.dto.PostPloggingRes;
import com.jupging.jupgingServer.plogging.repository.PloggingRepository;
import com.jupging.jupgingServer.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PloggingServiceImpl implements PloggingService{

    private final PloggingRepository ploggingRepository;
    private final GCSuploader GCSuploader;

    private static final String DIR_PLOGGING = "plogging";
    private static final String DIR_TRASH = "trash";

    @Override
    public PostPloggingRes savePlogging(User user, PostPloggingReq postPloggingReq) throws Exception {
        String routeImage = GCSuploader.uploadFile(postPloggingReq.getRouteImage(), DIR_PLOGGING);
        String trashImage = GCSuploader.uploadFile(postPloggingReq.getTrashImage(), DIR_TRASH);
        Plogging newPlogging = createPlogging(user, routeImage, trashImage, postPloggingReq);
        Plogging savedPlogging = ploggingRepository.save(newPlogging);
        return new PostPloggingRes(savedPlogging.getId());
    }

    @Override
    public Plogging createPlogging(User runner, String routeImage, String trashImage, PostPloggingReq postPloggingReq) throws Exception {
        return Plogging.builder().routeImage(routeImage).trashImage(trashImage)
                .calorie(postPloggingReq.getCalorie()).distance(postPloggingReq.getDistance())
                .avgPaceMin(postPloggingReq.getAvgPaceMin()).avgPaceSec(postPloggingReq.getAvgPaceSec())
                .runTimeHour(postPloggingReq.getRunTimeHour()).runTimeMin(postPloggingReq.getRunTimeMin())
                .runTimeSec(postPloggingReq.getRunTimeSec()).user(runner).build();
    }
}
