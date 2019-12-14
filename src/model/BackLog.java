package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BackLog implements Serializable {
    @Id @GeneratedValue
    private long id;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Colonne> listeColonne;

    public BackLog() {
        this.listeColonne = new ArrayList<>();
    }

    public BackLog(List<Colonne> listeColonne) {
        this.listeColonne = listeColonne;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Colonne> getListeColonne() {
        return listeColonne;
    }

    public void setListeColonne(List<Colonne> listeColonne) {
        this.listeColonne = listeColonne;
    }

    public void addColonne(String columnName) {
        Colonne c = new Colonne(columnName);
        this.listeColonne.add(c);
    }

    public void addColonne(String columnName, Colonne previous, Colonne next) {
        Colonne c = new Colonne(columnName, previous, next);
        this.listeColonne.add(c);
    }
}
