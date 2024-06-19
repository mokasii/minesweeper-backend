package de.htwberlin.webtechsose24;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Entity
@Table(name = "score")
public class Score {


    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nickname;
    private int timeInSeconds;
    private String difficulty;

    public Score() {}

    public Score(String nickname, int timeInSeconds, String difficulty) {
        this.nickname = nickname;
        this.timeInSeconds = timeInSeconds;
        this.difficulty = difficulty;
    }

}
