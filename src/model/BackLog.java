package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class BackLog implements Serializable {
    @Id @GeneratedValue
    private long id;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Colonne firstColonne;

    public BackLog() {}

    public BackLog(Colonne firstColonne) {
        this.firstColonne = firstColonne;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Colonne getFirstColonne() {
        return firstColonne;
    }

    public void setFirstColonne(Colonne listeColonne) {
        this.firstColonne = listeColonne;
    }

}
