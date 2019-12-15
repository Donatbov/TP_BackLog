package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Colonne implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    private String nom;
    @OneToOne
    private Colonne previousColumn;
    @OneToOne
    private Colonne nextColumn;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Entree> listeEntree;

    public Colonne() {
        this.listeEntree = new ArrayList<>();
    }

    public Colonne(String name) {
        this.listeEntree = new ArrayList<>();
        this.nom = name;
    }

    public Colonne(String name, Colonne previous, Colonne next) {
        this.listeEntree = new ArrayList<>();
        this.nom = name;
        this.previousColumn = previous;
        this.nextColumn = next;
    }

    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Colonne getPreviousColumn() {
        return previousColumn;
    }

    public void setPreviousColumn(Colonne previousColumn) {
        this.previousColumn = previousColumn;
    }

    public Colonne getNextColumn() {
        return nextColumn;
    }

    public void setNextColumn(Colonne nextColumn) {
        this.nextColumn = nextColumn;
    }

    public List<Entree> getListeEntree() {
        return listeEntree;
    }

    public void setListeEntree(List<Entree> listeEntree) {
        this.listeEntree = listeEntree;
    }

    public void addEntree(Entree e) {
        this.listeEntree.add(e);
    }
}
