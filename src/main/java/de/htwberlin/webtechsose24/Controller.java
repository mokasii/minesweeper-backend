package de.htwberlin.webtechsose24;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@CrossOrigin(origins = {"https://minesweeper-sidoma.onrender.com"})
public class Controller {

    @GetMapping("/")
    public List<User> index() {
        //test
        User entry = new User("test");
        User entry1 = new User("test1");
        User entry2 = new User("test2");
        return List.of(entry, entry1, entry2);
    }

}
