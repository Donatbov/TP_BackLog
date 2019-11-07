package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Colonne {
    @Id
    @GeneratedValue
    private long id;
    private String nom;
    @OneToOne
    private Colonne lastColumn;
    @OneToOne
    private Colonne nextColumn;

    public Colonne() {}

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Colonne getLastColumn() {
        return lastColumn;
    }

    public void setLastColumn(Colonne lastColumn) {
        this.lastColumn = lastColumn;
    }

    public Colonne getNextColumn() {
        return nextColumn;
    }

    public void setNextColumn(Colonne nextColumn) {
        this.nextColumn = nextColumn;
    }
}
