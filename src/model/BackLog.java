package model;

import javax.persistence.*;
import java.util.List;

@Entity
public class BackLog {
    @Id @GeneratedValue
    private long id;

    @OneToMany
    private List<Entree> listeEntree;

    public BackLog() {}

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
