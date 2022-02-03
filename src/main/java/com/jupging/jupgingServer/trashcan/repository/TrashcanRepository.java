package com.jupging.jupgingServer.trashcan.repository;

import com.jupging.jupgingServer.trashcan.domain.Trashcan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrashcanRepository extends JpaRepository<Trashcan, Long> {

    List<Trashcan> findAll();
}
