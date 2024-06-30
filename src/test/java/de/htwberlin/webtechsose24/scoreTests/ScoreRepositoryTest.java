package de.htwberlin.webtechsose24.scoreTests;

import de.htwberlin.webtechsose24.Score;
import de.htwberlin.webtechsose24.repository.ScoreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ScoreRepositoryTest {

    private ScoreRepository scoreRepository;

    @BeforeEach
    public void setup() {
        scoreRepository = Mockito.mock(ScoreRepository.class);
    }

    @Test
    public void testFindByCreatedAtAfter() {
        LocalDateTime now = LocalDateTime.now();
        Score score1 = new Score("user1", 100, "easy");
        score1.setCreatedAt(now.minusDays(2));
        Score score2 = new Score("user2", 200, "medium");
        score2.setCreatedAt(now.minusDays(1));
        Score score3 = new Score("user3", 300, "hard");
        score3.setCreatedAt(now);

        when(scoreRepository.findByCreatedAtAfter(now.minusDays(1))).thenReturn(Arrays.asList(score2, score3));

        List<Score> scores = scoreRepository.findByCreatedAtAfter(now.minusDays(1));

        assertEquals(2, scores.size());
        assertEquals(score2, scores.get(0));
        assertEquals(score3, scores.get(1));
    }

    @Test
    public void testFindByCreatedAtAfterAndDifficulty() {
        LocalDateTime now = LocalDateTime.now();
        Score score1 = new Score("user1", 100, "easy");
        score1.setCreatedAt(now.minusDays(2));
        Score score2 = new Score("user2", 200, "medium");
        score2.setCreatedAt(now.minusDays(1));
        Score score3 = new Score("user3", 300, "hard");
        score3.setCreatedAt(now);

        when(scoreRepository.findByCreatedAtAfterAndDifficulty(now.minusDays(1), "medium")).thenReturn(Arrays.asList(score2));

        List<Score> scores = scoreRepository.findByCreatedAtAfterAndDifficulty(now.minusDays(1), "medium");

        assertEquals(1, scores.size());
        assertEquals(score2, scores.get(0));
    }
}