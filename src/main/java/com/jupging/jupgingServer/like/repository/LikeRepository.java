package com.jupging.jupgingServer.like.repository;

import com.jupging.jupgingServer.like.entity.Like;
import com.jupging.jupgingServer.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findByToUserAndFromUser(User toUser, User fromUser);
    Optional<Integer> countByUser(User user);
}
