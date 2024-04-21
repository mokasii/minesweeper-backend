package de.htwberlin.webtechsose24;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class Controller {

    @GetMapping("/")
    public List<User> index() {
        User entry = new User("Test", "Test");
        User entry1 = new User("Test1", "Test");
        User entry2 = new User("Test2", "Test");
        User entry3 = new User("Test3", "Test");
        User entry4 = new User("Test4", "Test");
        return List.of(entry, entry1, entry2, entry3, entry4);
    }

}
