package pl.flutterdeveloper.springit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Vote {

    @Id
    @GeneratedValue
    private Long id;
    private int votes;

    //user
    //link

    public Vote() {
    }
}
