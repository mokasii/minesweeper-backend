package de.htwberlin.webtechsose24.scoreTests;

import de.htwberlin.webtechsose24.Score;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ScoreTest {

    @Test
    public void testScore() {
        Score score = new Score("test", 10, "easy");
        assertEquals("test", score.getNickname());
        assertEquals(10, score.getTimeInSeconds());
        assertEquals("easy", score.getDifficulty());
    }

    @Test
    public void testScorePrePersist() {
        Score score = new Score("test", 10, "easy");
        score.prePersist();
        assertEquals("test", score.getNickname());
        assertEquals(10, score.getTimeInSeconds());
        assertEquals("easy", score.getDifficulty());

        assertEquals(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES), score.getCreatedAt().truncatedTo(ChronoUnit.MINUTES));
    }

}
