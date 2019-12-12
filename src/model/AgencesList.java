package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// Va contenir la liste des agences créés
@Entity
public class AgencesList implements Serializable {
    @Id
    final long id = 0;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Agence> agences;

    public AgencesList() {
        agences  = new ArrayList<>();
    }

    public List<Agence> getAgences() {
        return agences;
    }

    public void setAgences(List<Agence> agences) {
        this.agences = agences;
    }

    public void addAgence(Agence a) {
        this.agences.add(a);
    }
}
