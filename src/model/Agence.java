package model;

import javax.persistence.*;

@Entity
public class Agence {
    @Id @GeneratedValue
    private long id;
    private String name;
    @OneToOne
    private BackLog backlog;

    public Agence() {}

    public Agence(String name, BackLog b) {
        this.name = name;
        this.backlog = b;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BackLog getBacklog() {
        return backlog;
    }

    public void setBacklog(BackLog backlog) {
        this.backlog = backlog;
    }

}
