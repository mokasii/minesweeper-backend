package de.htwberlin.webtechsose24;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Entity
@Table(name = "score")
public class Score {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickName;
    private int timeInSeconds;
    private String difficulty;

    public Score() {}

    public Score(String nickName, int timeInSeconds, String difficulty) {
        this.nickName = nickName;
        this.timeInSeconds = timeInSeconds;
        this.difficulty = difficulty;
    }

}
