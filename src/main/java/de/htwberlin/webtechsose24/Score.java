package de.htwberlin.webtechsose24;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Entity
@Table(name = "score")
public class Score {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private int timeInSeconds;
    private String difficulty;

    public Score() {}

    public Score(String nickName, int timeInSeconds, String difficulty) {
        this.name = nickName;
        this.timeInSeconds = timeInSeconds;
        this.difficulty = difficulty;
    }

}
