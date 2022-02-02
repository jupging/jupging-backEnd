package com.jupging.jupgingServer.plogging.repository;

import com.jupging.jupgingServer.plogging.domain.Plogging;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PloggingRepository extends JpaRepository<Plogging, Long> {

}
