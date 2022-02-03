package com.jupging.jupgingServer.trashcan.service;

import com.jupging.jupgingServer.common.BaseException;
import com.jupging.jupgingServer.trashcan.domain.Trashcan;
import com.jupging.jupgingServer.trashcan.dto.GetTrashcanRes;
import com.jupging.jupgingServer.trashcan.dto.PostTrashcanReq;
import com.jupging.jupgingServer.trashcan.dto.PostTrashcanRes;
import com.jupging.jupgingServer.trashcan.repository.TrashcanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.jupging.jupgingServer.common.BaseResponseStatus.DUPLICATE_KEY_ERROR;

@Service
@Transactional
@RequiredArgsConstructor
public class TrashcanServiceImpl implements TrashcanService{

    private final TrashcanRepository trashcanRepository;

    @Override
    @Transactional(readOnly = true)
    public List<GetTrashcanRes> findTrashcans(){
        List<Trashcan> trashcanList = trashcanRepository.findAll();
        List<GetTrashcanRes> trashcanDtoList = new ArrayList<>();
        for (Trashcan trashcan : trashcanList)
            trashcanDtoList.add(new GetTrashcanRes(trashcan));
        return trashcanDtoList;
    }

    @Override
    public PostTrashcanRes saveTrashcan(PostTrashcanReq postTrashcanReq) throws BaseException{
        Optional<Trashcan> existTrashcan = trashcanRepository.findByLatitudeAndLongitude(postTrashcanReq.getLatitude(), postTrashcanReq.getLongitude());
        if (existTrashcan.isPresent())
            throw new BaseException(DUPLICATE_KEY_ERROR);

        Trashcan newTrashcan = createTrashcan(postTrashcanReq);
        Trashcan savedTrashcan = trashcanRepository.save(newTrashcan);
        return new PostTrashcanRes(savedTrashcan.getId());
    }

    @Override
    public Trashcan createTrashcan(PostTrashcanReq postTrashcanReq) {
        return  Trashcan.builder()
                        .latitude(postTrashcanReq.getLatitude())
                        .longitude(postTrashcanReq.getLongitude())
                        .build();
    }
}
