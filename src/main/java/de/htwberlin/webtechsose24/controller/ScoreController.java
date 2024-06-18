package de.htwberlin.webtechsose24.controller;

import de.htwberlin.webtechsose24.Score;
import de.htwberlin.webtechsose24.repository.ScoreRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public Score addScore(@RequestBody Score score) {
        System.out.println("received score: " + score.getNickName() + " " + score.getTimeInSeconds() + " " + score.getDifficulty() );
        return scoreRepository.save(score);
    }
}
