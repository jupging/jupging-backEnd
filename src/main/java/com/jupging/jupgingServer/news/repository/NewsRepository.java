package com.jupging.jupgingServer.news.repository;

import com.jupging.jupgingServer.news.domain.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
}