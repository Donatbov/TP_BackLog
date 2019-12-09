package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BackLog implements Serializable {
    @Id @GeneratedValue
    private long id;
    @OneToMany
    private List<Entree> listeEntree;

    public BackLog() {
        this.listeEntree = new ArrayList<>();
    }

    public BackLog(List<Entree> listeEntree) {
        this.listeEntree = listeEntree;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Entree> getListeEntree() {
        return listeEntree;
    }

    public void setListeEntree(List<Entree> listeEntree) {
        this.listeEntree = listeEntree;
    }
}
