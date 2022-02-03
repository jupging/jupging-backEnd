package com.jupging.jupgingServer.trashcan.service;

import com.jupging.jupgingServer.trashcan.domain.Trashcan;
import com.jupging.jupgingServer.trashcan.dto.GetTrashcanRes;
import com.jupging.jupgingServer.trashcan.repository.TrashcanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TrashcanServiceImpl implements TrashcanService{

    private final TrashcanRepository trashcanRepository;

    @Override
    @Transactional(readOnly = true)
    public List<GetTrashcanRes> findTrashcans(){
        // TODO : JWT 검사 필요
        List<Trashcan> trashcanList = trashcanRepository.findAll();
        List<GetTrashcanRes> trashcanDtoList = new ArrayList<>();
        for (Trashcan trashcan : trashcanList)
            trashcanDtoList.add(new GetTrashcanRes(trashcan));
        return trashcanDtoList;
    }
}
