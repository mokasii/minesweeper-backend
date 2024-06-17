package de.htwberlin.webtechsose24.repository;

import de.htwberlin.webtechsose24.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {
}
