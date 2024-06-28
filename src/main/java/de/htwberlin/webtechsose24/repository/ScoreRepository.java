package de.htwberlin.webtechsose24.repository;

import de.htwberlin.webtechsose24.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {
    List<Score> findByCreatedAtAfter(LocalDateTime createdAt);
    List<Score> findByCreatedAtAfterAndDifficulty(LocalDateTime createdAt, String difficulty);
}
