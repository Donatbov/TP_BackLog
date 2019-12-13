package beans;

import ejb.AgenceEJB;
import model.Agence;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@RequestScoped
public class BacklogAgenceMgntBean implements Serializable {
    @EJB
    protected AgenceEJB agenceEJB;
    private Agence agence;

    public BacklogAgenceMgntBean() {}

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

//    public ArrayList<Agence> getAgences() {
//
//    }
}
