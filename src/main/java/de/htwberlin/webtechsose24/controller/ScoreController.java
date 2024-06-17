package de.htwberlin.webtechsose24.controller;

import de.htwberlin.webtechsose24.Score;
import de.htwberlin.webtechsose24.repository.ScoreRepository;
import de.htwberlin.webtechsose24.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
        return scoreRepository.findAll();
    }

    @PostMapping
    public Score addScore(@RequestBody Score score) {
        return scoreRepository.save(score);
    }
}
