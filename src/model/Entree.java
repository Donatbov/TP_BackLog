package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Entree implements Serializable {
    @Id @GeneratedValue
    private long id;
    private String name;
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    private int priority;
    private int estimation;
    private String description;
    @OneToMany
    private List<Commentaire> comments;
    @ManyToOne
    private Colonne column;

    public Entree() {
        this.comments = new ArrayList<>();
        this.creationDate = new Date(System.currentTimeMillis());
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

    public Date getCreationDate() {
        return creationDate;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getEstimation() {
        return estimation;
    }

    public void setEstimation(int estimation) {
        this.estimation = estimation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Commentaire> getComments() {
        return comments;
    }

    public void addComment(Commentaire comment) {
        this.comments.add(comment);
    }

    public Colonne getColumn() {
        return column;
    }

    public void setColumn(Colonne column) {
        this.column = column;
    }
}
