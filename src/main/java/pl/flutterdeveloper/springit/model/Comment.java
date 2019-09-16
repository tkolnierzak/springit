package pl.flutterdeveloper.springit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Comment {

    @Id
    @GeneratedValue
    private Long id;
    private String body;

    //link

    public Comment() {
    }
}
