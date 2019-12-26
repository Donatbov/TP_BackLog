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

    boolean hasNext () {
        return this.nextColumn != null;
    }

    boolean hasPrevious () {
        return this.previousColumn != null;
    }

    /**
     * Logic to move a Colonne one step back in the Backlog
     * Note : for this to work properly, this.previousColumn shouldn't be null
     * If you call this function, always set {@param isFirstCall} to true
     * @return null if the first Backlog's Colonne doesn't change after calling this method,
     *         the new first Colonne otherwise
     */
    public Colonne moveBack (boolean isFirstCall) {
        Colonne oldPrevious = this.previousColumn;
        if (this.previousColumn.hasPrevious()) {
            this.previousColumn.previousColumn.setNextColumn(this);
            this.setPreviousColumn(this.previousColumn.previousColumn);
        } else {
            this.setPreviousColumn(null);
        }
        if (isFirstCall) {
            oldPrevious.moveNext(false);
        }
        this.setNextColumn(oldPrevious);
        if(isFirstCall && this.previousColumn == null) {
            return this;
        }
        return null;
    }

    /**
     * Logic to move a Colonne one step next in the Backlog
     * Note : for this to work properly, this.nextColumn shouldn't be null
     * If you call this function, always set {@param isFirstCall} to true
     * @return null if the first Backlog's Colonne doesn't change after calling this method,
     *         the new first Colonne otherwise
     */
    public Colonne moveNext (boolean isFirstCall) {
        Colonne oldNext = this.nextColumn;
        if (this.nextColumn.hasNext()) {
            this.nextColumn.nextColumn.setPreviousColumn(this);
            this.setNextColumn(this.nextColumn.nextColumn);
        } else {
            this.setNextColumn(null);
        }
        if (isFirstCall) {
            oldNext.moveBack(false);
        }
        this.setPreviousColumn(oldNext);
        if(isFirstCall && this.previousColumn.previousColumn == null) {
            return this.previousColumn;
        }
        return null;
    }
}
