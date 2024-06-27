package de.htwberlin.webtechsose24.controller;

import de.htwberlin.webtechsose24.Score;
import de.htwberlin.webtechsose24.repository.ScoreRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:5173","https://minesweeper-sidoma.onrender.com"})
@RequestMapping("/api/scores")
public class ScoreController {

    private final ScoreRepository scoreRepository;

    public ScoreController(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    @GetMapping
    public List<Score> getAllScores() {
        return scoreRepository.findAll(Sort.by(Sort.Direction.ASC, "timeInSeconds"));
    }

    @GetMapping("/day/{difficulty}")
    public List<Score> getScoresLastDay(@PathVariable String difficulty) {
        LocalDateTime oneDayAgo = LocalDateTime.now().minusDays(1);
        return scoreRepository.findByCreatedAtAfterAndDifficulty(oneDayAgo, difficulty);
    }

    @GetMapping("/week/{difficulty}")
    public List<Score> getScoresLastWeek(@PathVariable String difficulty) {
        LocalDateTime oneWeekAgo = LocalDateTime.now().minusWeeks(1);
        return scoreRepository.findByCreatedAtAfterAndDifficulty(oneWeekAgo, difficulty);
    }

    @GetMapping("/month/{difficulty}")
    public List<Score> getScoresLastMonth(@PathVariable String difficulty) {
        LocalDateTime oneMonthAgo = LocalDateTime.now().minusMonths(1);
        return scoreRepository.findByCreatedAtAfterAndDifficulty(oneMonthAgo, difficulty);
    }

    @PostMapping
    public Score addScore(@RequestBody Score score) {
        return scoreRepository.save(score);
    }
}
